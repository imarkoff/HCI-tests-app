package com.imarkoff.hci_tests.tests

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel
import com.imarkoff.hci_tests.R
import com.imarkoff.hci_tests.data.Test

fun startTest(context: Context, test: Test) {
    val intent = Intent(context, PassingTestScreenActivity::class.java)
    intent.putExtra("test", test)
    context.startActivity(intent)
}

@Composable
fun LoadTests(
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    val topPadding = PaddingValues(top = innerPadding.calculateTopPadding())

    val testViewModel: MainViewModel = viewModel(factory =  MainViewModel.factory)
    val tests = testViewModel.tests.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(topPadding),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(tests.value) { test ->
            TestButton(test)
        }
    }
}

@Composable
fun TestButton(
    test: Test,
    context: Context = LocalContext.current
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = MaterialTheme.shapes.large
            )
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = test.testName,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = test.testDescription
                )
            }
            Button(
                onClick = {
                    startTest(context, test)
                },
                Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.start_test))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestsActivity() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.tests))
                }
            )
        }
    ) { innerPadding ->
        LoadTests(innerPadding)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun TestsActivityPreview() {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TestButton(
            test = Test(
            testId = 0,
            testName = "Test name",
            testDescription = "Test description here ...",
            questions = emptyList()
        ),
            context = LocalContext.current
        )
    }
}