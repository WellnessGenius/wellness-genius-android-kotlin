package com.wellnessgenius.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.wellnessgenius.android.repositories.HealthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val healthRepository: HealthRepository
) : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _stepCount = MutableLiveData<Int>()
    val stepCount: LiveData<Int> = _stepCount

    private val _calories = MutableLiveData<Int>()
    val calories: LiveData<Int> = _calories

    private val _heartRate = MutableLiveData<Int>()
    val heartRate: LiveData<Int> = _heartRate

    private val _bioAge = MutableLiveData<Int>()
    val bioAge: LiveData<Int> = _bioAge

    init {
        loadUserData()
    }

    private fun loadUserData() {
        FirebaseAuth.getInstance().currentUser?.let { user ->
            _userName.value = user.displayName ?: "User"
        }
    }

    fun loadHealthData() {
        viewModelScope.launch {
            try {
                // In a real app, these would come from Health Connect or a wearable
                _stepCount.value = 8432
                _calories.value = 425
                _heartRate.value = 72
                _bioAge.value = 32
                
                // After that's working, we'd fetch from the actual health repository
                healthRepository.getStepCount()?.let { steps ->
                    _stepCount.value = steps
                }
                
                healthRepository.getActiveCalories()?.let { cals ->
                    _calories.value = cals
                }
                
                healthRepository.getHeartRate()?.let { hr ->
                    _heartRate.value = hr
                }
                
                healthRepository.getBioAge()?.let { age ->
                    _bioAge.value = age
                }
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }
}
