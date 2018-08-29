package di.penopllast.com.inforemover.data.repositories

/**
 * { @link RepositoryDbImpl}
 */
interface RepositoryDb {
    fun insertApp(packageName: String, name: String)
    fun deleteApp(packageName: String, name: String)
    fun printData()
}