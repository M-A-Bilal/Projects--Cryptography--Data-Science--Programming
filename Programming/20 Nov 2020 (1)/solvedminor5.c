// to access the input scanf()

// and output printf()

#include <stdio.h>  

// to access the functions like

// pipe(), fork(), execvp(), dup2()

#include <unistd.h>  

// to access the string functions like

// strtok()

#include <string.h>

// to access function wait()

#include <sys/wait.h>

#include <stdlib.h>

int main()

{

  // declare a variable to hold the process id

  pid_t p_id;

  // declare a variable to hold the index value

  int array_index;

  // declare the string to hold the user input

  // as command

  char userIn_Command[128];

  // use a continuous loop

  while (1)

  {

      // display the prompt for the user

      printf("minor5> ");

      // read the input from the user

      scanf("%[^\n]", userIn_Command);

      // check the condition that whether the user

      // inputs a command called "quit"

      // If the user inputs quit command then exit from

      // the script

      if (strcmp(userIn_Command, "quit") == 0)

      {

          printf("\n");

          break;

      }

      // if there are any usage of pipelining or redirection

      // display the error message and exit from the script

      if (strchr(userIn_Command, '|') != NULL || strchr(userIn_Command, '>') != NULL ||

          strchr(userIn_Command, '<') != NULL)

      {

          printf("Error: Cannot perform the multiple command operations or directions\n");

          break;

      }

      // declare the variables to hold the process

      int p_pids[2];

      // create the system call to pipe() from kernal

      // and display the error message

      if (pipe(p_pids) < 0)

      {

          printf("Error: Pipe creation failed!\n");

      }

      // create the child process

      p_id = fork();

      // condition to check whether the fork() is

      // created. If so, display an error message

      if (p_pids < 0)

      {

          printf("Error: fork() failed!\n");

          break;

      }

      // if the child process is created

      if (p_id == 0)

      {

          // close pipe in child process

          close(p_pids[0]);

          // create duplicate of the standard output

          dup2(p_pids[1], STDOUT_FILENO);

          // close the pipe in child process

          close(p_pids[1]);

          // declare a variable to store path

          // to execute the command

          char *command_path;

          // declare an array of string to hold the options

          char * args[32];

          // tokenize the command by using the delimiter at " "(single space)

          char *cmd_token = strtok(userIn_Command, " ");

          // store the token value

          command_path = cmd_token;

          args[0] = cmd_token;

          array_index = 1;

          // loop until all the options in the command are

          // tokenized

          while (1)

          {

              // get the next token

              cmd_token = strtok(NULL, " ");

              // condition to check whether the token is null

              // or not

              if (cmd_token == NULL)

              {

                  break;

              }

              // store the token if it is not null

              args[array_index] = cmd_token;

              // increment the index

              array_index++;

          }

          // last parameter to the command should be NULL */

          args[array_index] = NULL;

                     

          /* calling exec function with command path and parameters */

          if (strcmp(args[0], "cd") == 0 || strcmp(args[0], "history") == 0 ||

              strcmp(args[0], "exit") == 0)

          {

              printf("%s: Command not found\n", args[0]);

              break;

          }

          if (execvp(command_path, args) < 0 )

          {

              printf("%s: Command not found\n", args[0]);

              break;

          }

      }

      else

      {          

          /* closing writing end of pipe in parent process */

          close(p_pids[1]);

          /* reading ouput written to pipe in child process and

          * writing to console */

          while (1)

          {

              char output[1024];

              int n = read(p_pids[0], output, 1024);

              if (n <= 0)

              {

                  break;

              }

              output[n] = '\0';

              printf("%s", output);

          }

          /* closing read end of pipe1 */

          close(p_pids[0]);

          /* waiting until child process complete its execution */

          wait(NULL);

      }

      /* skipping newline character read while scanf() */

      getchar();

  }

  exit(0);

}