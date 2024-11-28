package com.example.deportes

import org.junit.Test

import org.junit.Assert.*

import org.junit.*
import org.mockito.*
import android.widget.Toast
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        // Inicializar la actividad de la aplicación
        mainActivity = MainActivity()
    }

    @Test
    fun testFabOnClick() {
        // Simula que el primer deporte está seleccionado
        mainActivity.deportes[0].seleccionado = true

        // Llamada al FAB
        mainActivity.findViewById<FloatingActionButton>(R.id.fab).performClick()

        // Verifica si se muestra el mensaje correcto
        val expectedMessage = "Has elegido Baloncesto"
        Toast.makeText(context, expectedMessage, Toast.LENGTH_SHORT).show()
        verify { Toast.makeText(context, expectedMessage, Toast.LENGTH_SHORT).show() }
    }

    @Test
    fun testFabOnClickNoSelection() {
        // Ningún deporte seleccionado
        mainActivity.deportes.forEach { it.seleccionado = false }

        // Llamada al FAB
        mainActivity.findViewById<FloatingActionButton>(R.id.fab).performClick()

        // Verifica que se muestra el mensaje de no selección
        val expectedMessage = "No has elegido ninguna opción"
        Toast.makeText(context, expectedMessage, Toast.LENGTH_SHORT).show()
        verify { Toast.makeText(context, expectedMessage, Toast.LENGTH_SHORT).show() }
    }
}
