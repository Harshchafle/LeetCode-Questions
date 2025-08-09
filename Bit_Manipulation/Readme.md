# Bit Manipulation: The Hacker's Toolkit 💻
## Ever wondered how to solve problems with lightning speed or optimize your code to its absolute limit? Bit manipulation is the secret weapon of top-tier programmers. This guide breaks down the essential concepts, from basic operations to advanced techniques, to help you master this powerful skill.

## 1. The Building Blocks: Basic Bitwise Operations
Think of every number as a sequence of on/off switches (bits). These operations let you flip, check, and move those switches with surgical precision.

### AND (&): Your bitwise detective. Use it to check if a specific bit is set. A common use is x & (1 << i), which tells you if the i-th bit of x is 1.

### OR (|): The bitwise builder. Use this to ensure a bit is turned on. The operation x | (1 << i) sets the i-th bit of x to 1, no matter what its original state was.

### XOR (^): The bitwise toggler. This is your go-to for flipping a bit. x ^ (1 << i) flips the i-th bit, changing a 1 to a 0 and vice-versa. It's also a superstar for finding unique elements.

### NOT (~): The bitwise inverter. It flips every single bit. Just remember that ~x is the same as (-x) - 1.

### Left Shift (<<): The bitwise multiplier. Shifting bits to the left is a lightning-fast way to multiply by powers of two. x << i is equivalent to x∗2 
i
 .

### Right Shift (>>): The bitwise divider. Shifting bits to the right is the fastest way to perform integer division by powers of two. x >> i is roughly x/2 
i
 .

## 2. Advanced Maneuvers: Key Techniques & Identities
Now for the fun part. These techniques move beyond simple operations to solve real-world problems.

### The Power of Two: An elegant one-liner: a number x is a power of two if (x > 0) && ((x & (x - 1)) == 0).

### Counting Set Bits (Hamming Weight): Don't loop through every bit. Use Brian Kernighan's Algorithm, a beautiful piece of logic that counts bits in a flash. The trick is n &= (n - 1), which clears the lowest set bit in each iteration.

### Swap without a Temp Variable: A classic interview question. Using XOR, you can swap two variables a and b in just three lines without using a third variable.

### Finding a Unique Element: When an array has a single unique number and all others appear twice, simply XOR all elements together. The result is the unique number, as a ^ a cancels to 0.

## 3. The Big Leagues: Advanced Concepts & Applications
Bit manipulation isn't just for small tricks; it's a foundation for powerful algorithms and data structures.

### Masking: Think of a bitmask as a stencil. You can use it with the AND operator to isolate specific bits, allowing you to extract or modify only the parts of a number you care about.

### Subsets & Power Sets: A common problem is generating all possible subsets of a set. Bit manipulation provides an elegant solution: each number from 0 to 2 
n
 −1 corresponds to a unique subset. The i-th bit of the number tells you if the i-th element is in the subset.

## Dynamic Programming with Bitmasking: For problems where the "state" can be represented by a collection of boolean values (e.g., which items have been visited), a bitmask can represent that state in a single integer. This technique is crucial for solving problems like the Traveling Salesman Problem on a small scale.
