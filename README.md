## Introduction

Welcome to my second college assignment on Java. In this assignment, I was required to create a simple text-based menu application to manage some tasks. This application include some features such as being able to view all tasks, update a task, marking a task as complete, undo it, etc. This assignment applied some theory regarding the concept of Array, Stack (LIFO), and LinkedList respectively.

## My Approach

The program seperates between Array version and LinkedList version. In the array version, I preloaded the app with 7 tasks. These tasks are included within a fixed size array. Hence you can't add nor delete any task within this array. However you could update a certain task to a new one.

On the other hand, the LinkedList version of the app gives you the ability to update the task list dynamically. Meaning you could add and delete task in any way you want. I preloaded it with 3 tasks in this version for you then add new ones or delete some tasks respectively.

The undo feature utilises the concept of Stack or LIFO Principle. It stores the most recently marked task as complete by pushing the task index into the stack. If you want to undo it, it'll pop the latest element from the top.

I used both 

## Challenges faced

1. **Not being able to preload tasks in LinkedList**. I resolved this issue by including these initial load within a static block
2. **Time**. Pretty much self-explanatory. I must improve my time management when doing future assignments next time. Truth to be told, I worked on this app in a single day with little to no wiggle room for adding creative spin to it. Hence, I only focused on the core functionality of this app, especially the error handling.
3. **Keeping the code organised**. Resolved this by adding proper comments for each features within the app.
4. **Scanner nextline() glitch**. Sometimes the scanner doesn't properly asks for a user String input. I resolved it by adding additional scanner.nextline() command in some areas to prevent this issue from happening.