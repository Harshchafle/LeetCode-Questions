# Bit Manipulation Concepts
## This is a concise revision guide to essential bit manipulation concepts.

### 1. Basic Operations:

AND (&): Sets a bit to 1 only if both corresponding bits are 1. Useful for masking and checking if a bit is set.

x & (1 << i): Checks if the i-th bit of x is set.

OR (|): Sets a bit to 1 if at least one corresponding bit is 1. Useful for setting a bit.

x | (1 << i): Sets the i-th bit of x.

XOR (^): Sets a bit to 1 if the corresponding bits are different. Useful for toggling bits and finding unique elements.

x ^ (1 << i): Toggles the i-th bit of x.

NOT (~): Flips all bits. ~x is equivalent to (-x) - 1.

Left Shift (<<): Shifts bits to the left, filling with zeros. x << i is equivalent to $x \* 2^i$.

Right Shift (>>): Shifts bits to the right.

Logical Right Shift: Fills with zeros.

Arithmetic Right Shift: Fills with the sign bit. x >> i is equivalent to x/2 
i
  for non-negative x.

### 2. Key Techniques & Identities:

Set/Clear/Toggle a Bit:

Set bit i: num | (1 << i)

Clear bit i: num & ~(1 << i)

Toggle bit i: num ^ (1 << i)

Finding Power of Two: A number x is a power of two if and only if (x > 0) && ((x & (x-1)) == 0).

Counting Set Bits (Hamming Weight):

Brian Kernighan's Algorithm: while (n > 0) { n = n & (n - 1); count++; }. This method efficiently clears the lowest set bit in each iteration.

Finding the i-th bit: (num >> i) & 1 or (num & (1 << i)) != 0.

Swapping two numbers without a temporary variable:

C++

a = a ^ b;
b = a ^ b; // b = (a^b)^b = a
a = a ^ b; // a = (a^b)^a = b
Finding the unique element in an array where all other elements appear twice: XOR all the elements. The result is the unique number.

### 3. Advanced Concepts:

Masking: Using a bitmask to isolate specific bits. x & mask extracts the bits that are 1 in the mask.

Lowest Set Bit: x & (-x) returns a number with only the lowest set bit of x set.

Gray Code: A sequence of binary numbers where each successive value differs in only one bit. g = n ^ (n >> 1).

Subsets/Power Set: Iterating through all subsets of a set of n elements can be done by counting from 0 to 2 
n
 −1 and using the bit representation to decide which elements to include. For each number i from 0 to 2 
n
 −1, the j-th bit of i determines if the j-th element is in the subset.

Dynamic Programming with Bitmasking: Useful for problems where states can be represented by a bitmask, such as the Traveling Salesman Problem on a small number of vertices. Each bit in the mask represents a visited city.