package com.example.univisiontest.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
class AppComponent {
}