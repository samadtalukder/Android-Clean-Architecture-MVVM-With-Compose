/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.utils

interface CustomMapper<in E, T> {
    fun mapFrom(from: E): T
}