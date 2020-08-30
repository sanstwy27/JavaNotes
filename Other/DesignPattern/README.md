## Design Pattern

#### 1. Seven Principles of Java Design Pattern

- SOLID
  - The **S**ingle Responsibility Principle
    - Classes should have a single responsibility and thus only a single reason to change.
  - The **O**pen/Closed Principle
    - Classes and other entities should be open for *extension* but closed for *modification*.
  - The **L**iskov Substitution Principle (Richter substitution principle)
    - Objects should be replaceable by their subtypes.
  - The **I**nterface Segregation Principle
    - Interfaces should be client specific rather than general.
  - The **D**ependency Inversion Principle
    - Depend on abstractions rather than concretions.
- Demeter's Law
  - it is also called [Least know the law], an  object should maintain a minimum understanding of other objects, the closer the relationship between class and class, the higher the degree of coupling
- Principles of composite reuse
  - Try to use synthetic aggregation, and use less inheritance, programming for the interface instead of programming for the implementation.

Ref:
https://medium.com/@severinperez/b71c4f3f883f
https://www.programmersought.com/article/28134601553/

#### 2. UML Class Diagram

- Association
  - Association is a relationship between two objects. In other words, association defines the multiplicity between objects. You may be aware of one-to-one, one-to-many, many-to-one, many-to-many all these words define an association between objects. Aggregation is a special form of association. Composition is a special form of aggregation.
- Aggregation
  - Aggregation is a special case of association. A directional association between objects. When an object ‘has-a’ another object, then you have got an aggregation between them. Direction between them specified which object contains the other object. Aggregation is also called a “Has-a” relationship.
- Composition
  - Composition is a special case of aggregation. In a more specific manner, a restricted aggregation is called composition. When an object contains the other object, if the contained object cannot exist without the existence of container object, then it is called composition.
- Generalization
  - Generalization uses a “is-a” relationship from a specialization to the generalization class.
- Realization (Implementation)
  - Realization is a relationship between the blueprint class and the object containing its respective implementation level details.
- Dependency
  - Change in structure or behaviour of a class affects the other related class, then there is a dependency between those two classes. It need not be the same vice-versa. When one class contains the other class it this happens.

Ref:
https://javapapers.com/oops/association-aggregation-composition-abstraction-generalization-realization-dependency/








