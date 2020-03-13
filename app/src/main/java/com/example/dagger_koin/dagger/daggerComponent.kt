package com.example.dagger_koin.dagger

import dagger.Component

@Component(modules = [Module::class])
interface dComponent {
    fun ProvideDaggerModel():daggerModel
    fun ProvideVMDaggerFactory():VMFactoryProvider
}