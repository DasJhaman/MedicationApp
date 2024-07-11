package com.example.medicationapp.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import com.example.medicationapp.data.RepositoryResult
import com.example.medicationapp.domain.AssociatedDrugUseCase
import com.example.medicationapp.domain.models.AssociatedDrug
import com.example.medicationapp.ui.common.ContentState
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DashboardScreen.userId
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardScreenViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var associatedDrugUseCase: AssociatedDrugUseCase
    private lateinit var sut: DashboardScreenViewModel
    private val mockData = listOf(AssociatedDrug("DrugName", "300 mg", ""))

    @Before
    fun beforeTest() {
        Dispatchers.setMain(dispatcher)
        savedStateHandle = SavedStateHandle().apply {
            set(key = userId, value = "TestValue")
        }
        associatedDrugUseCase = mockk()
    }

    @Test
    fun `uiData correctly sets the userId Value in savedStateHandle`() {
        sut = DashboardScreenViewModel(
            savedStateHandle = savedStateHandle,
            associatedDrugUseCase = associatedDrugUseCase
        )
        coEvery { associatedDrugUseCase.invoke() } returns flow { emit(RepositoryResult.Success(mockData)) }

        assertEquals("TestValue", sut.uiData.value.userId)
    }

    @Test
    fun `associatedDrugUseCase should return success with correct data`() = runTest(dispatcher) {
        coEvery { associatedDrugUseCase.invoke() } returns flow { emit(RepositoryResult.Success(mockData)) }

        sut = DashboardScreenViewModel(
            savedStateHandle = savedStateHandle,
            associatedDrugUseCase = associatedDrugUseCase
        )

        val result = associatedDrugUseCase.invoke().first()
        assertTrue(result is RepositoryResult.Success)
        assertEquals(1, (result as RepositoryResult.Success).data.size)
    }

    @Test
    fun `getAssociatedDrugs sets ContentState to LOADING then SUCCESS`() = runTest(dispatcher) {
        coEvery { associatedDrugUseCase.invoke() } returns flow {
            emit(RepositoryResult.Loading)
            advanceTimeBy(100)
            emit(RepositoryResult.Success(mockData))
        }

        sut = DashboardScreenViewModel(
            savedStateHandle = savedStateHandle,
            associatedDrugUseCase = associatedDrugUseCase
        )

        val states = mutableListOf<DashboardUIData>()
        val job = launch {
            sut.uiData.collect { states.add(it) }
        }

        // Trigger the function to fetch associated drugs
        sut.getAssociatedDrugs()

        // Advance the dispatcher to process the coroutine
        advanceUntilIdle()

        // Check if the states were properly set
        assertEquals(ContentState.LOADING, states.first().contentState)
        assertEquals(ContentState.SUCCESS, states.last().contentState)
        assertEquals(mockData, states.last().associateDrugs)

        job.cancel()
    }

    @Test
    fun `getAssociatedDrugs sets ContentState to ERROR on failure`() = runTest(dispatcher) {
        coEvery { associatedDrugUseCase.invoke() } returns flow {
            emit(RepositoryResult.Loading)
            advanceTimeBy(100)
            emit(RepositoryResult.Error(null, "Error fetching data"))
        }

        sut = DashboardScreenViewModel(
            savedStateHandle = savedStateHandle,
            associatedDrugUseCase = associatedDrugUseCase
        )

        val states = mutableListOf<DashboardUIData>()
        val job = launch {
            sut.uiData.collect { states.add(it) }
        }

        // Trigger the function to fetch associated drugs
        sut.getAssociatedDrugs()

        // Advance the dispatcher to process the coroutine
        advanceUntilIdle()

        // Check if the states were properly set
        assertEquals(ContentState.LOADING, states.first().contentState)
        assertEquals(ContentState.ERROR, states.last().contentState)

        job.cancel()
    }

    @After
    fun afterTest() {
        Dispatchers.resetMain()
    }
}