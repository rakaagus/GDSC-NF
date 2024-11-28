package com.nurulfikri.gdscnf.presentation.screen.auth.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.nurulfikri.gdscnf.ui.theme.GDSCNFTheme
import com.nurulfikri.gdscnf.ui.theme.blackColor
import com.nurulfikri.gdscnf.ui.theme.greyColorDark
import com.nurulfikri.gdscnf.ui.theme.purple
import com.nurulfikri.gdscnf.utils.ActionKeyboard
import com.nurulfikri.gdscnf.utils.TypeKeyboard

@Composable
fun RegisterForm(
    label: String,
    value: String,
    keyboardType: TypeKeyboard,
    keyboardActions: ActionKeyboard,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tipeKeyboard = when (keyboardType) {
        TypeKeyboard.EMAIL -> KeyboardType.Email
        TypeKeyboard.TEXT -> KeyboardType.Text
        TypeKeyboard.NUMBER -> KeyboardType.Number
    }
    val tipeKeyboardAction = when (keyboardActions) {
        ActionKeyboard.NEXT -> ImeAction.Next
        ActionKeyboard.END -> ImeAction.Done
    }

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = greyColorDark
            )
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.labelSmall,
        shape = MaterialTheme.shapes.extraSmall,
        colors = TextFieldDefaults.colors(
            cursorColor = purple,
            unfocusedIndicatorColor = greyColorDark,
            focusedIndicatorColor = purple,
            focusedTextColor = purple,
            focusedLabelColor = purple,
            unfocusedLabelColor = greyColorDark,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = tipeKeyboardAction,
            keyboardType = tipeKeyboard
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun RegisterPasswordForm(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .fillMaxWidth(),
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = greyColorDark
            )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Outlined.Visibility
            } else {
                Icons.Outlined.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                "Visibility Icon"
            } else {
                "Visibility Off Icon"
            }

            IconButton(
                onClick = { passwordVisible.value = !passwordVisible.value }
            ) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.labelSmall,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        shape = MaterialTheme.shapes.extraSmall,
        colors = TextFieldDefaults.colors(
            cursorColor = purple,
            unfocusedIndicatorColor = greyColorDark,
            focusedIndicatorColor = purple,
            focusedTextColor = purple,
            focusedLabelColor = purple,
            unfocusedLabelColor = greyColorDark,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun DropDownSelection(
    label: String,
    options: List<String>,
    selectionOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(
            value = selectionOption,
            onValueChange = {},
            placeholder = {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = blackColor
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            textStyle = MaterialTheme.typography.labelSmall,
            readOnly = true,
            singleLine = true,
            shape = MaterialTheme.shapes.extraSmall,
            colors = TextFieldDefaults.colors(
                cursorColor = blackColor,
                unfocusedIndicatorColor = greyColorDark,
                focusedIndicatorColor = purple,
                focusedTextColor = purple,
                focusedLabelColor = purple,
                unfocusedLabelColor = greyColorDark,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.background(Color.White)) {
            options.forEach { selectionOptions ->
                DropdownMenuItem(onClick = {
                    onOptionSelected(selectionOptions)
                    expanded = false
                }) {
                    Text(
                        text = selectionOptions,
                        style = MaterialTheme.typography.labelSmall,
                        color = greyColorDark
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun Dropdowntext() {
    GDSCNFTheme {
        var selectedOption by remember { mutableStateOf("") }
        val options = listOf("Option 1", "Option 2", "Option 3")
        DropDownSelection(
            label = "Coba",
            options = options,
            selectionOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )
    }
}