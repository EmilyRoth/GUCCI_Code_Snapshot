# GUCCI_Code_Snapshot

## Functionality
* Reads input in from file (input.txt) and processes queries in order
* Handles invalid queries, even if they match the original pattern
* Outputs in desired format
* 

## Assumptions
* Queries are not always entered in order (ex. glob means I, how much is glob glob ?, prok means X)
* Values can change
* Input is read from a file
* Outputting to the console rather than writing to a file
* Can only operate on one thread
* Standard roman numeral assignments (I = 1, V = 5, etc.)

## Design Choices
* O(N*M) due to performing worst case runtime operation O(N) while looping through the input file, which would be O(M), code processes queries in O(N) time
* Thought about checking that the regex matches the valid intergalaticNumerals and materials but decided recompiling the regex pattern each time a new input is added would get expensive
* Made the input a read from file to make testing easier
* Did not add functionality to read file names (only reads from input.txt), did not seem important to the problem
* Added conversion class so that way if the regex expressions needed to be changed, the code that handles the storage and calculations of intergalaticNumerals and minerals remains consistent and modular


