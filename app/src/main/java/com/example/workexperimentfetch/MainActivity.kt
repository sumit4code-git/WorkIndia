package com.example.workexperimentfetch

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workexperimentfetch.taskExperiment.worksTasks.Resource
import com.example.workexperimentfetch.taskExperiment.worksTasks.viewmodel.GetExperimentsViewModel
import com.example.workexperimentfetch.ui.theme.WorkExperimentFetchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GetExperimentsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkExperimentFetchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, vm: GetExperimentsViewModel) {
    LaunchedEffect(key1 = true) {
        vm.getExperiment()
    }
    val experiments = vm.experiments.collectAsState().value
    when (experiments) {
        is Resource.Success -> {
            Text(text = "Success${experiments.data.experimentName}")
        }

        is Resource.Error -> {
            Text(text = "Error")
        }

        is Resource.Loading -> {
            CircularProgressIndicator(modifier = Modifier.size(20.dp))
        }
        else -> {
            Unit
        }
    }
}