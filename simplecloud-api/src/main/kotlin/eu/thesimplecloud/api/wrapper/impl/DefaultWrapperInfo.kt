package eu.thesimplecloud.api.wrapper.impl

import eu.thesimplecloud.clientserverapi.lib.json.GsonExclude
import eu.thesimplecloud.clientserverapi.lib.json.JsonData
import eu.thesimplecloud.api.wrapper.IWritableWrapperInfo

data class DefaultWrapperInfo(
        private val name: String,
        private val host: String,
        private var maxSimultaneouslyStartingServices: Int,
        private var maxMemory: Int
) : IWritableWrapperInfo {

    @GsonExclude
    private var authenticated = false

    @GsonExclude
    private var usedMemory: Int = 0

    @GsonExclude
    private var templatesReceived = false

    override fun setUsedMemory(memory: Int) {
        this.usedMemory = memory
    }

    override fun setMaxSimultaneouslyStartingServices(amount: Int) {
        this.maxSimultaneouslyStartingServices = amount
    }

    override fun setMaxMemory(memory: Int) {
        this.maxMemory = memory
    }

    override fun setAuthenticated(boolean: Boolean) {
        this.authenticated = boolean
    }

    override fun getName(): String = this.name

    override fun getHost(): String = this.host

    override fun getMaxSimultaneouslyStartingServices(): Int = this.maxSimultaneouslyStartingServices

    override fun getUsedMemory(): Int = this.usedMemory

    override fun getMaxMemory(): Int = this.maxMemory

    override fun isAuthenticated(): Boolean = this.authenticated

    override fun hasTemplatesReceived(): Boolean = this.templatesReceived

    override fun setTemplatesReceived(boolean: Boolean) {
        this.templatesReceived = boolean
    }

    override fun toString(): String {
        return JsonData.fromObjectWithGsonExclude(this).getAsJsonString()
    }

}