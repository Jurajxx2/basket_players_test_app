package com.juraj.common.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ItemDetailField(modifier: Modifier = Modifier, fieldName: String, data: String) {
    Row(
        modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            modifier = Modifier.weight(1f, true),
            text = fieldName,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.weight(1f, true),
            text = data,
            textAlign = TextAlign.Center
        )
    }
}