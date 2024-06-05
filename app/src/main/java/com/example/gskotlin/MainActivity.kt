package com.example.gskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.example.gskotlin.adapter.ItemsAdapter
import com.example.gskotlin.ui.theme.GSKotlinTheme
import com.example.gskotlin.viewmodel.ItemsViewModel

class MainActivity : ComponentActivity() {
    val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()

        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextPraia = findViewById<EditText>(R.id.editTextPraia)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)

        button.setOnClickListener {
            if (editTextPraia.text.isEmpty()) {
                editTextPraia.error = "Preencha os dados"
                return@setOnClickListener
            }
            if (editTextCidade.text.isEmpty()) {
                editTextCidade.error = "Preencha os dados"
                return@setOnClickListener
            }
            if (editTextEstado.text.isEmpty()) {
                editTextEstado.error = "Preencha os dados"
                return@setOnClickListener
            }

            viewModel.addItem(editTextPraia.text.toString())
            viewModel.addItem(editTextCidade.text.toString())
            viewModel.addItem(editTextEstado.text.toString())

            editTextPraia.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }


        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }



    }
}


