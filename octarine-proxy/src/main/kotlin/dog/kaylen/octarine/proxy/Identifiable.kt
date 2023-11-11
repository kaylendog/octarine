package dog.kaylen.octarine.proxy

interface Identifiable {
    val name: String
    val identifier
        get() = Identifier("octarine", name)
}
