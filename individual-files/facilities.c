/* MANUAL CODE REVIEW - MICHAEL LAMB

What are the inputs? 
  The unique() function accepts a pointer to a c-string and
  a pointer to a buffer

How is it processed? 
  Terms in a c-string are separated into a buffer and,
  if the term is unique, the term is added to the list

What are the outputs?
  The output is the list of unique terms

Who / What initializes the code?
  main() initializes an array of 1000 types and then calls the
  unique() function

What are the major functions?
  main() and unique()

What objects are created / used?
  The only variables created are c-strings stored in char arrays

--------------------------------------------------------

Defects / issues found (relevance of each defect)
  in unique() function:
    infinite loop, for loop has no arguments and is ambiguous
  in main() function:
    types[] array initialized with a hard-coded value

Types / categories of defects
  Standards
  Ambiguous design

Overall quality assessment
  Open

Provide a quality grade / score (that can be compared to other fragments)
  B
*/
#include <stdio.h>
#include <string.h>

char *sequence = "class department college office field library";
void unique( const char *list, char *buf )
{
  char name[100];
  int k;
  buf[0] = 0;
  for(;;) //DEFECT SEVERITY 2: infinite loop, ambiguous
    {
      while( *list == ' ' ) list++;
      k = sscanf( list, "%s", name );
      if( k != 1 ) break;
      if( !strstr( buf, name ) )
        { 
          strcat( buf, " " );
          strcat( buf, name ); 
        }
      list += strlen(name);
    }
}

int main()
{
  char types[1000]; //DEFECT SEVERITY 2: hard-coded value not const
  unique( types, sequence );
  printf( "Facilities used: %s\n", types );
  return 0;
}
