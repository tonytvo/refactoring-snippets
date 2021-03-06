# Introduce the indirection layer
- when we refactoring, we often end up in situation where single change causing cascading effects of changes and we retreat in our corner and cry, and recently, I have learned a good trick from J.B. Rainberger to introduce indirection layer to help us making small steps incrementally
# Session Outline
- 5 mins connect: 
  - what are you hoping to achieve when you sit down to refactor some code? what is your motivation?
  - ask the group to name some refactoring that they have used, and the corresponding code smells
  - what can go wrong when refactoring? How do you know if your refactoring was safe?
  - how do you know when to refactor?
- 10 min concept
  - [Martin's Fowler definitions](https://martinfowler.com/bliki/DefinitionOfRefactoring.html)
  - purpose of refactoring is to make code easier to understand and cheaper to modify
    - it's a necessary part of iterative and incremental development. You don't plan the entire design up front, you take working code and change the design to support new functionality
    - when you run into code that harder than necessary to understand and modify. You do a series of safe refactoring on it to improve readability and reduce complexity
    - the trick is to practice so that you can execute the refactoring without conscious thought. With enough patience and practice, you can execute refactoring with unconscious thoughts and you don't have to switch often among the questions "which refactoring will improve this design?" and "how do I perform this micro-step?".
    - once you could do refactoring without conscious thoughts, instead of thinking "I know how to safely lead the design where I want it to go", to the more powerful "I can just start removing duplication and improving names and a good design will emerge" and you might find helpful designs that are simpler than the ones that your intuition can see.
  - introduce indirection layer
    - we typically create the warm and dry place
    - gradually changing the client to call this new warm and dry place, so we can start making incremental change without introducing cascading effect on the system.
    - we could remove the deprecated methods/classes or inline the warm and dry place.
  - my other favorite refactoring snippets
    - extract method
    - extract variable
    - rename method, classes, fields
    - golden master
    - extract as a separate map
    - introduce parameters
    - introduce indirection steps (warm and dry place) 
- X minutes do
  - It seems like OrderLines is a good home (domain concept) for Order.lines field, once you extract Order.lines into OrderLines, we could see a whole bunch of behavior should belong into OrderLines as well
  - [ ] checkout https://github.com/tonytvo/event-sourcing-example
  - **adding the wrapper**
    - [ ] checkout introduce-indirection-starting-point branch
    - [ ] extract all methods that references Order.lines as the following snippets
      - [extract updateItem](./snippets/lines-update-item.gif)
      - [extract asList](./snippets/extract-aslist-lines.gif)
      - [extract isEmpty](./snippets/extract-is-empty.gif)
    - [ ] in method asList, create the wrapper object `OrderLines` that wrap `lines` and provide getter to return wrapped objects `lines`
      - Option 1:
        - [wrap unwrap lines](./snippets/wrap-unwrap-object.gif)
        - [introduce parameter OrderLines](./snippets/introduce-parameter-orderlines.gif)
      - Option 2:
        - [introduce parameter for lines](./snippets/introduce-lines-parameter.gif)
        - [introduce parameter object OrderLines for lines](./snippets/introduce-parameter-objects-orderlines.gif)
    - [ ] [move asList to OrderLines](./snippets/move-aslist-to-orderlines.gif)
    - follow the previous steps to move updateItem to OrderLines
      - One of:
        - Option 1
          - [wrap unwrap lines](./snippets/wrap-unwrap-object.gif)
          - [introduce parameter OrderLines](./snippets/introduce-parameter-orderlines.gif)
        - Option 2
          - [introduce parameter for lines](./snippets/introduce-lines-parameter.gif)
          - [introduce parameter object for lines using existing object OrderLines](./snippets/introduce-parameter-object-use-existing-orderlines.gif)
      - [ ] [move updateItem to OrderLines](./snippets/move-update-item-to-orderlines.gif)
    - [ ] move isEmpty to OrderLines
  - **liberating the wrapped**
    - [ ] checkout introduce-indirection-starting-point branch
    - [ ] extract all methods that references Order.lines as the following snippets
      - [extract updateItem](./snippets/lines-update-item.gif)
      - [extract asList](./snippets/extract-aslist-lines.gif)
      - [extract isEmpty](./snippets/extract-is-empty.gif)
    - [ ] *liberating the wrapped* by extracting delegate class OrderLines
      - [extract delegate OrderLines](./snippets/extract-delegate-orderlines.gif) 
    - [ ] clean up, remove unused method updateItem, asList, isEmpty in Order
      - [remove unused method isEmpty](./snippets/delete-unused-method-is-empty.gif) 

- 5 min reflect
  - what's your favorite refactoring snippets that you use daily the most?
  - tell me 3 ways refactoring affect your productivity as a developer. For examples:
    - they help you to think at a higher level of abstraction
    - as a navigator if you know the names of these you can communicate more effectively with the driver
    - it takes time to learn them
    - a long sequence of small refactoring means you can make a larger change safely, avoiding bugs.
  - when should you refactor?
  - did you feel safe when you refactor? would you work differently if you didn't have fast, reliable test?
  - how would you define 'code smell'? write a definition on a sticky note and take it with you to put next to your screen

# References
- https://github.com/codecop/dependency-breaking-katas
- https://tonytvo.github.io/what-simple-way-share-learn-refactor/
- https://github.com/tomphp/event-sourcing-example
