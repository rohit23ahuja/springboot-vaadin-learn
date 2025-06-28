Vaadin flow framework - user interface using java only
Vaadin hilla framework - user interface in React and Type script. Java backend integration through Hilla
Flow and Hilla views can be combined in one application.

probably vaadin to run you need vaadin plugin in intellij
vaadin needs both npm and maven to download dependencies - https://vaadin.com/docs/latest/flow/configuration/development-mode/node-js#proxy-settings-for-downloading-frontend-toolchain

Downloaded from central: https://repo.maven.apache.org/maven2/com/vaadin/vaadin-prod-bundle/24.8.0/vaadin-prod-bundle-24.8.0.jar (9.2 MB at 4.7 MB/s)
[INFO] Reflections took 3018 ms to scan 305 urls, producing 18566 keys and 94263 values
[INFO] Couldn't find node.exe. Installing Node and npm to C:\Users\Admin\.vaadin.
[INFO] Installing node version v22.15.1
[INFO] Downloading https://nodejs.org/dist/v22.15.1/node-v22.15.1-win-x64.zip to C:\Users\Admin\.vaadin\node-v22.15.1-win-x64.zip
[INFO] Unpacking C:\Users\Admin\.vaadin\node-v22.15.1-win-x64.zip (35136406 bytes) into C:\Users\Admin\.vaadin\node\tmp
[INFO] Copying node binary from C:\Users\Admin\.vaadin\node\tmp\node-v22.15.1-win-x64\node.exe to C:\Users\Admin\.vaadin\node\node.exe
[INFO] Extracting npm
[INFO] Local node installation successful.
[INFO] Visited 116 classes. Took 203 ms.
[INFO] Copying frontend resources from jar files ...
[INFO] Visited 307 resources. Took 341 ms.
[INFO]
[INFO] --- compiler:3.14.0:compile (defaul


The view class is a target of Route. if it has parameters it should implement HasUrlParameter<T> and define the parameter type using generics

App Layout is a component for the root layout of a Vaadin application. It provides predefined areas for the navigation drawer, the header, and the view’s content.