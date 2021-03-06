# What3Words Java API Implementation for GE Smallworld

### Introduction


This example illustrates the implementation of What3Words' Java API for GE Smallworld.

For More information on What3Words please refer to What3Words(https://what3words.com)

![](https://github.com/Aramideh/What3Words/blob/main/resources/screenshot.png)


This modules uses the Magik-Java Interoperability, a supported mechanism to call code written in Java™ from GE Smallworld. This provides 
an efficient way of exposing Java to Magik, allowing access to existing Java code and third-party libraries written in Java.

Project could be separated in two parts, java module part which is used to impelement the what3words class and the magik part which the plugin is implemented.
Java class is available at (https://github.com/Aramideh/What3Words/blob/main/Module/Java/Java%20Project/src/com/aramideh/sadeq/what3words/sw_what3words.java)


### Getting Started

for convinence please copy the files in the specified directories.

* copy swj_magik_what3words_module in Magik_Module folder to the %SMALLWORLD_GIS%\interop.demo\interop_demo_product\modules\
* copy contents of the "Final Jar Files, Exported from Java Project" folder's Jar files to %SMALLWORLD_GIS%\interop.demo\interop_demo_product\libs\
* smallworld_product.add_product(:interop_demo_product)
* compile the modules

* Add below code to the config.xml of the Application
```
   <plugin name="what3words_plugin" class_name="what3words_plugin">
		 <properties>
			<property name="api_key" value="Your_API_KEY" />
			<property name="language" value="en" />
			<property name="maximum_number_of_auto_suggestions" value="10" />
			<property name="clip_to_country" value="GB,FR" />
			<property name="use_floating_info_window" value="true" />
		</properties>	
		<export>
		  <toolbar source_name="what3words"/>
		</export>
	</plugin>


```
* Get your API key from What3Words Developers site, and put the key in  api_key propery

* Add below code to the gui.xml of the Application

```
	<dock name="top">
		<toolbar name="what3words"/>
	</dock>

```

 DONE! Enjoy!
 
A short demo is uploaded to the youtube. watch(https://youtu.be/wEV8YJlLVYc)

#### More technical information about the plugin is in the wiki page of this repository.(https://github.com/Aramideh/What3Words/wiki)

 
### Author Notes

 * This modules is tested on Smallworld 5.1.9 (Long support )


### Authors
* [**Sadeq Aramideh**](https://github.com/Aramideh)

