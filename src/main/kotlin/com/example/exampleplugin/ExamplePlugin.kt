package com.example.exampleplugin

import kr.entree.spigradle.annotations.PluginMain
import org.bukkit.plugin.java.JavaPlugin

@PluginMain // important for plugin.yml generation
class ExamplePlugin : JavaPlugin() {

    override fun onEnable() { }

}