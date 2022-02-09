# 10 Refactoring Snippets
- for me to learn and share what's the most common 10 refactoring snippets that people use daily
# Session Outline
- 5 min connect: 
  - what's are you hoping to achieve, when you sit down to refactor some code? what is your motivation?
  - ask the group to name some refactorings that they have used, and the coressponding code smells
  - what can go wrong when refactoring? How do you know if your refacotring was safe?
  - how do you know when to refactor?
- 10 min concept
  - [Martin's Fowler definitions](https://martinfowler.com/bliki/DefinitionOfRefactoring.html)
  - purpose of refactoring is to make code easier to understand and cheaper to modify
    - it's a necessary part of iterative and incremental development. You don't plan the entire design up front, you take working code and change the design to support new functionality
    - when you run into code that harder than necessary to understand and modify. You do a series of safe refactorings on it to improve readability and reduce complexity
    - the trick is to practice so that you can execute the refactoring without conscious thought. Without enough patience and practice, you have to switch more often among the questions "which refactorings will improve this design?" and "how do I perform this micro-step?".
    - once you could do refactoring without conscious thoughts, instead of thinking "I know how to safely lead the design where I want it to go", to the more powerful "I can just start removing duplication and improving names and a good design will emerge" and you might find helpful designs that are simpler than the ones that your intuition can see.
  - my 10 refactoring snippets
    - extract method
    - extract variable
    - rename method, classes, fields
    - golden master
    - extract as a separate map
    - introduce parameters
    - introduce indirection steps (warm and dry place) 
- X minutes do
  - https://github.com/tonytvo/refactoring-snippets
  - [] checkout golden-master-practice
    - [] add golden master test
- 5 min reflect
  - how would you define 'code smell'? write a definition on a sticky note and take it with you to put next to your screen
  - what's your favorite refactoring snippets that you use daily the most?
  - tell me 3 ways refactoring affect your productivity as a developer. For examples:
    - they help you to think at a higher level of abstraction
    - as a navigator if you know the names of these you can communicate more effectively with the driver
    - it takes time to learn them
    - a long sequence of small refactorings means you can make a larger change safely, avoiding bugs.
  - when should you refactor?
  - did you feel safe when you refactor? would you work differently if you didn't have fast, reliable test?

Feedback
- more interactive, more slides, where it easier to retain
- golden master (easier to grasp)
- draw pictures for each of the refactoring method.
- focus introduce indirection steps that move the implementation details up the call stack.
- ask 1 questions if only has 5 mins left.
- explain domain vocabulary depends on the audience.
- if you watch yourself give a talk, pay attention to "that could have been better"
# References
- https://github.com/codecop/dependency-breaking-katas
- https://tonytvo.github.io/what-simple-way-share-learn-refactor/
- https://github.com/tomphp/event-sourcing-example
