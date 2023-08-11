# ChorusLib
> A little library mod for Chorus Team

### For Dev
> Setup your Gradle build script
> You can integrate and automatically download ChorusLib for your mod project using Gradle.
Just add the following to your build script (build.gradle):

> ### Repositories
> ```gradle
> maven {
>    name = "Modrinth"
>    url = "https://api.modrinth.com/maven"
>    content {
>        includeGroup "maven.modrinth"
>    }
> } 
> ```


> ### Forge Dependencies
> ```gradle
> implementation fg.deobf("maven.modrinth:EzwvOfTZ:F6MTMI3O")
> ```

>### Fabric Dependencies
> ```gradle
> modImplementation("maven.modrinth:EzwvOfTZ:4HRCbCub")
> ```



### Setting Up End Biomes
> **Forge**
>```java
>@Mod(ExampleForgeMod.MOD_ID)
>public class ExampleForgeMod {
>
>    public ExampleForgeMod() {
>        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
>        bus.addListener(this::commonSetup);
>        MinecraftForge.EVENT_BUS.register(this);
>    }
>
>    private void commonSetup(FMLCommonSetupEvent event) {
>        initEndBiomes();
>    }
>    
>    private void initEndBiomes(){
>        TheEndBiomes.addHighlandsBiome(ExampleEndBiomes.EXAMPLE_END_BIOMES, 1);
>    }
>}
>```

> **Fabric**
>```java
>public class ExampleFabricMod implements ModInitializer {
>
>    @Override
>    public void onInitialize() {
>        initEndBiomes();
>    }
>
>    public static void initEndBiomes(){
>        TheEndBiomes.addHighlandsBiome(ExampleEndBiomes.EXAMPLE_END_BIOMES, 1);
>    }
>
>}
>```

