- Integration Testing Framework should be a separate project
that references dependencies.
- The reason why it should be a separate project is because we are going to have helper files

- Set up an empty maven project
- Give it a package name an dproject name
- Inside pm.xml add following dependencies:
    - JUnit
    - JUnit parameters
    - Build Configurations:
    
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>13</source>
                    <target>13</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

- You want to add java version so you don't get 
errors

### List of http stsatuses
- [httpstatuses.com](httpstatuses.com)

### Object Mapping
#### AKA marhsalling/unmarshalling
Looking at your json structure and creating 
a java class with fields and methods that fethces it.
Then use mapping library to do mapping. 

### RestAssured API testing library uses fluent api



