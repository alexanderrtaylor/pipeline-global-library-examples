@NonCPS def call(classLoader) {
  System.out.println ("CLASSLOADER -> " + "$classLoader")
  //((groovy.lang.GroovyClassLoader.InnerLoader)classLoader).getURLs().each {url->
  /*classLoader.getURLs().each {url->
     System.out.println ("- ${url.toString()}")
  }*/
  if (classLoader.parent) {
     printClassPath(classLoader.parent)
  } else {
    System.out.println ("----------")
  }
}
//printClassPath this.class.classLoader
