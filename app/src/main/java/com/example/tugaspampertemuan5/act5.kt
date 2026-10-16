package com.example.tugaspampertemuan5

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@Composable
fun TampilanACT5() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = colorResource(R.color.warna_latar)
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                Image(
                    painter = painterResource(R.drawable.baru),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
                KartuFormBiodata(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .offset(y = 155.dp)
                )
            }
        }
    }
}
@Composable
fun KartuFormBiodata(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var androidDipilih by remember { mutableStateOf(false) }
    var uiuxDipilih by remember { mutableStateOf(false) }
    var webDipilih by remember { mutableStateOf(false) }

    var tampilkanHasil by remember { mutableStateOf(false) }
    var tampilkanPesan by remember { mutableStateOf(false) }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = 24.dp,
            topEnd = 24.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.putih)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(R.string.judul_form),
                color = colorResource(R.color.ungu_utama),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = stringResource(R.string.petunjuk_form),
                color = colorResource(R.color.teks_sekunder),
                fontSize = 9.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            )
            {
                InputBiodata(
                    value = namaDepan,
                    onValueChange = { namaDepan = it },
                    hint = stringResource(R.string.nama_depan),
                    modifier = Modifier.weight(1f)
                )
                InputBiodata(
                    value = namaBelakang,
                    onValueChange = { namaBelakang = it },
                    hint = stringResource(R.string.nama_belakang),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            InputBiodata(
                value = email,
                onValueChange = { email = it },
                hint = stringResource(R.string.email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            )
            {
                KolomTanggal(
                    tanggal = tanggalLahir,
                    onTanggalDipilih = { tanggalLahir = it },
                    modifier = Modifier.weight(1f)
                )
                PilihanExperience(
                    experience = experience,
                    onExperienceDipilih = { experience = it },
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = stringResource(R.string.pilih_skill),
                modifier = Modifier.fillMaxWidth(),
                color = colorResource(R.color.teks_utama),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PilihanSkill(
                    teks = stringResource(R.string.skill_android),
                    dipilih = androidDipilih,
                    saatDipilih = { androidDipilih = it }
                )

                PilihanSkill(
                    teks = stringResource(R.string.skill_uiux),
                    dipilih = uiuxDipilih,
                    saatDipilih = { uiuxDipilih = it }
                )

                PilihanSkill(
                    teks = stringResource(R.string.skill_web),
                    dipilih = webDipilih,
                    saatDipilih = { webDipilih = it }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val skillTerpilih = androidDipilih || uiuxDipilih || webDipilih
                    if (
                        namaDepan.isBlank() ||
                        namaBelakang.isBlank() ||
                        email.isBlank() ||
                        tanggalLahir.isBlank() ||
                        experience.isBlank() ||
                        !skillTerpilih
                    ) {
                        tampilkanPesan = true
                    } else {
                        tampilkanHasil = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.ungu_utama)
                )
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                    color = colorResource(R.color.putih),
                    fontSize = 11.sp
                )
            }
        }
    }
    if (tampilkanPesan) {
        AlertDialog(
            onDismissRequest = { tampilkanPesan = false },
            confirmButton = {
                TextButton(onClick = { tampilkanPesan = false }) {
                    Text(stringResource(R.string.pilih))
                }
            },
            title = {
                Text(stringResource(R.string.judul_form))
            },
            text = {
                Text(stringResource(R.string.pesan_kosong))
            },
            containerColor = colorResource(R.color.putih)
        )
    }
    if (tampilkanHasil) {
        val daftarSkill = listOfNotNull(
            if (androidDipilih) stringResource(R.string.skill_android) else null,
            if (uiuxDipilih) stringResource(R.string.skill_uiux) else null,
            if (webDipilih) stringResource(R.string.skill_web) else null
        ).joinToString()

        AlertDialog(
            onDismissRequest = { tampilkanHasil = false },
            confirmButton = {
                TextButton(onClick = { tampilkanHasil = false }) {
                    Text(stringResource(R.string.pilih))
                }
            },
            title = {
                Text(stringResource(R.string.hasil_biodata))
            },
            text = {
                Text(
                    stringResource(
                        R.string.format_hasil,
                        namaDepan,
                        namaBelakang,
                        email,
                        tanggalLahir,
                        experience,
                        daftarSkill
                    )
                )
            },
            containerColor = colorResource(R.color.putih)
        )
    }
}
@Composable
fun InputBiodata(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(38.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = colorResource(R.color.garis_input),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            if (value.isEmpty()) {
                Text(
                    text = hint,
                    color = colorResource(R.color.teks_sekunder),
                    fontSize = 10.sp
                )
            }

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = colorResource(R.color.teks_utama),
                    fontSize = 10.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun KolomTanggal(
    tanggal: String,
    onTanggalDipilih: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val kalender = Calendar.getInstance()

    Box(
        modifier = modifier
            .height(38.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                1.dp,
                colorResource(R.color.garis_input),
                RoundedCornerShape(12.dp)
            )
            .clickable {
                DatePickerDialog(
                    context,
                    { _, tahun, bulan, hari ->
                        onTanggalDipilih(
                            "$hari/${bulan + 1}/$tahun"
                        )
                    },
                    kalender.get(Calendar.YEAR),
                    kalender.get(Calendar.MONTH),
                    kalender.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (tanggal.isBlank()) {
                    stringResource(R.string.tanggal_lahir)
                } else {
                    tanggal
                },
                color = colorResource(R.color.teks_utama),
                fontSize = 10.sp
            )

            Text(
                text = "▦",
                color = colorResource(R.color.teks_utama),
                fontSize = 14.sp
            )
        }
    }
}
@Composable
fun PilihanExperience(
    experience: String,
    onExperienceDipilih: (String) -> Unit,
    modifier: Modifier = Modifier
)



