package com.example.exercise2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDua(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onSelectionChanged1 : (String) -> Unit,
    onSelectionChanged2 : (String) -> Unit,
    pilihanDosen :List<String>,
    ) {

    var nama by rememberSaveable {
        mutableStateOf("")
    }

    var nim by rememberSaveable {
        mutableStateOf("")
    }

    var konsentrasi by rememberSaveable {
        mutableStateOf("")
    }

    var judulskripsi by remember {
        mutableStateOf("")
    }

    var listData: MutableList<String> = mutableListOf(nama, nim, konsentrasi, judulskripsi)

    var dosenYgDipilih1 by remember {
        mutableStateOf("")
    }

    var dosenYgDipilih2 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(1.dp, Color.Gray), modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = stringResource(id = R.string.titleform),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)))
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.nama),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)))
                OutlinedTextField(
                    value = nim,
                    onValueChange = { nim = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.nim),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)))
                OutlinedTextField(
                    value = konsentrasi,
                    onValueChange = { konsentrasi = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.konsentrasi),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)))
                OutlinedTextField(
                    value = judulskripsi,
                    onValueChange = { judulskripsi = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.judul),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)))
                pilihanDosen.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = dosenYgDipilih1 == item,
                        onClick = {
                            dosenYgDipilih1 = item
                            onSelectionChanged1(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically){
                        RadioButton(selected = dosenYgDipilih1 == item,
                            onClick = {
                                dosenYgDipilih1 = item
                                onSelectionChanged1(item)}
                        )
                        Text(item)
                    }
                }
            }
        }
    }
}