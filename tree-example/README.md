# Example of TREE Usage

Each node of the tree can contain an Attribute or a List of Children nodes.
Children does not contain a reference to it's parents because for this use case it was not required.
A Product contains a List of nodes. Using ArrayList to hold the nodes so we can keep the order of insertion.
For specialized objects we can extend Product and add a Builder pattern for better abstraction of attributes creation.

* To run directly
  * ./gradlew bootRun
* To generate runnable jar artifact under build/libs path
  * ./gradlew clean build
    
PS. The description of this task is a bit confusing, but it says we should keep the order and the attributes should have hierarchical structure, so Trees sounds like the better choice for this data.
