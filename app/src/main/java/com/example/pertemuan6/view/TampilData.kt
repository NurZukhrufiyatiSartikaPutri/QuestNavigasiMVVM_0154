package com.example.pertemuan6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    nama: String = "",
    jenisK: String = "",
    alamat: String = "",
    onBackBtnClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.tampil), color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(id = R.string.nama_lengkap),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (nama.isNotBlank()) nama else "Contoh Nama",
                    modifier = Modifier.padding(top = 4.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    color = Color.Cyan,
                    thickness = 1.dp
                )

                Text(
                    text = stringResource(id = R.string.jenis_kelamin),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (jenisK.isNotBlank()) jenisK else "Lainnya",
                    modifier = Modifier.padding(top = 4.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    color = Color.Cyan,
                    thickness = 1.dp
                )

                Text(
                    text = stringResource(id = R.string.alamat),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (alamat.isNotBlank()) alamat else "Yogyakarta",
                    modifier = Modifier.padding(top = 4.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    color = Color.Cyan,
                    thickness = 1.dp
                )
            }


        }
    }
}