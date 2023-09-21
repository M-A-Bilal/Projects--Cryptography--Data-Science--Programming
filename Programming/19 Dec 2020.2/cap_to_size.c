



void cap_to_size(array_int_t* arrptr){ 
    if (arrptr != NULL && arrptr->capacity != arrptr->size){ // checking if pointer isnt null and not equal to size
        if (arrptr->size < 5){ // if size is less than 5
            arrptr->capacity = 5; // then changing the value to 5 i.e. larger of two
            if (arrptr->elems != NULL)  arrptr->elems = malloc(sizeof(int) * 5); // allocating space 
            else{
                free(arrptr->elems); // deallocating memory
                arrptr->elems = malloc(sizeof(int) * 5);// allocating space
            }
        }else{ // if size is greater than 5
            arrptr->capacity = arrptr->size; // changing the capacity to size because its the larger value
            if (arrptr->elems != NULL){ 
                arrptr->elems = malloc(sizeof(int) * arrptr->size);// allocating space
            }else{
                free(arrptr->elems);// deallocating memory
                arrptr->elems = malloc(sizeof(int) * arrptr->size);// allocating space
            }
        }
    }
}