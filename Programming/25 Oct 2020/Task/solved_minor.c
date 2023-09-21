#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NITEMS 10               // number of items in shared buffer

// shared variables
char shared_buffer[NITEMS];     // echo buffer
int shared_count;               // item count

pthread_mutex_t mutex;          // pthread mutex
pthread_cond_t bufferNotEmpty;  // pthread condition variable for consumer thread
pthread_cond_t bufferNotFull;   // pthread condition variable for producer thread

unsigned int prod_index = 0;    // producer index into shared buffer
unsigned int cons_index = 0;    // consumer index into shared buffer

// function prototypes
void * producer(void *arg);
void * consumer(void *arg);

int main() 
{ 
    pthread_t prod_tid, cons_tid1, cons_tid2; 

    // initialize pthread variables
    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&bufferNotEmpty, NULL);
    pthread_cond_init(&bufferNotFull, NULL);

    // start producer thread
    pthread_create(&prod_tid, NULL, producer, NULL);

    // start consumer threads
    pthread_create(&cons_tid1, NULL, consumer, NULL);
    pthread_create(&cons_tid2, NULL, consumer, NULL);

    // wait for threads to finish
    pthread_join(prod_tid, NULL);
    pthread_join(cons_tid1, NULL);
    pthread_join(cons_tid2, NULL);

    // clean up
    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&bufferNotEmpty);
    pthread_cond_destroy(&bufferNotFull);

    return 0;
}

// producer thread executes this function
void * producer(void *arg)
{
    char key;

    while (1)
    {
        // read input key
        scanf("%c", &key);

        while (1)
        {
            // acquire mutex lock
            pthread_mutex_lock(&mutex);

            // if buffer is full, release mutex lock and check again
            if (shared_count == NITEMS)
            {
                // Signal consumer thread and sleep
                pthread_cond_signal(&bufferNotEmpty);
                pthread_cond_wait(&bufferNotFull,&mutex);
                pthread_mutex_unlock(&mutex);
                break;
            }

            else
                break;
        }

        // store key in shared buffer
        shared_buffer[prod_index] = key;

        // update shared count variable
        shared_count++;


        // update producer index
        if (prod_index == NITEMS - 1)
            prod_index = 0;
        else
            prod_index++;

        // release mutex lock and signal consumer thread
        pthread_mutex_unlock(&mutex); 
        pthread_cond_signal(&bufferNotEmpty);
    }

    return NULL;
}

// consumer thread executes this function
void * consumer(void *arg)
{
    char key;

    int id = (int)pthread_self();

    while (1)
    {
        while (1)
        {
            	// acquire mutex lock
    		pthread_mutex_lock(&mutex);

    		// while buffer is empty, wait
    		while (shared_count == 0)
    		{
        		pthread_cond_wait(&bufferNotEmpty,&mutex);
    		} 

    		// read key from shared buffer
    		key = shared_buffer[cons_index];

    		// echo key
    		printf("consumer %d %c\n", id, key);

    		// update shared count variable
    		shared_count--;

    		// update consumer index
    		if (cons_index == NITEMS - 1)
        		cons_index = 0;
    		else
        		cons_index++;

    		// release mutex lock and signal producer thread
    		pthread_mutex_unlock(&mutex);
    		pthread_cond_signal(&bufferNotFull);
    	}

    	return NULL;
	}
}