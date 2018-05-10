#include<conio.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
#include<math.h>
#include<time.h>
//dump_line
void clear() {
	while (getchar() != '\n');
}



int inputInt(char *mess, char *error, int min, int max) {
	int number;
	int d, k;
	char m;
	do {
		d = 1;
		printf("%s", mess);
		k = scanf("%d%c", &number, &m);
		if (k == 0 || m != '\n') {
			clear();
			printf("%s", error);
		} else if (number < min || number > max) {
			printf("%s", error);
		} else d = 0;
	} while (d == 1);


	return number;
}


void inputArr(int arr[], int size) {
	int i;
	printf("Input Array: \n");
	for (i = 0; i < size; i++) {
		printf("Input element arr[%d]: ", i);
		scanf("%d", &arr[i]);
	}
}
//[1,2,3,4,5,6,7]
void displayArr(int arr[], int size) {
	int i;
	printf("The array:\n");
	printf("[ %d,", arr[0]);
	for (i = 1; i < size - 1; i++) {
		printf(" %d,", arr[i]);
	}
	printf(" %d ]", arr[size - 1]);
}
//tra ve -1 neu ko tim thay, tra ve vi tri cua bien trong mang
int search(int arr[], int size, int value) {
	int index = -1;
	int i;
	for (i = 0; i < size; i++) {
		if (arr[i] == value) return i;
	}
	return index;
}
//xoa phan tu co gia tri la value trong mang arr voi size phan tu truyen vao
void removeFirst(int arr[], int *size, int value) {
	int temp = *size;
	int index = search(arr, temp, value);
	int i;
	for (i = index; i < temp - 1; i++) {
		arr[i] = arr[i + 1];
	}
	*size = temp - 1;

}
//xoa toan bo cac phan tu value co trong mang
void removeAll(int arr[], int *size, int value) {
	int temp = *size;
	while (search(arr, temp, value) != -1) {
		removeFirst(arr, &temp, value);
	}
	*size = temp;
}

void swap(int *a, int *b) {
	(*a) = (*a) + (*b);
	(*b) = (*a) - (*b);
	(*a) = (*a) - (*b);
}

void sortAsc(int arr[], int size) {
	int i;
	int j;
	for (i = 0; i < size - 1; i++) {
		for (j = i + 1; j < size; j++) {
			if (arr[i] > arr[j]) {
				swap(&arr[i], &arr[j]);
			}
		}

	}
}

void sortDesc(int arr[], int size) {
	int i;
	int j;
	for (i = 0; i < size - 1; i++) {
		for (j = i + 1; j < size; j++) {
			if (arr[i] < arr[j]) {
				swap(&arr[i], &arr[j]);
			}
		}

	}
}

void reserver(int arr[], int size) {

	int i;
	int j = size - 1;
	for (i = 0; i < size / 2; i++) {
		swap(&arr[i], &arr[j]);
		j--;
	}
}

int max(int arr[], int size) {
	int i;
	int re = arr[0];
	for (i = 1; i < size; i++) {
		if (arr[i] > re) re = arr[i];
	}
	return re;
}

int min(int arr[], int size) {
	int i;
	int re = arr[0];
	for (i = 1; i < size; i++) {
		if (arr[i] < re) re = arr[i];
	}
	return re;
}

float average(int arr[], int size) {
	int i;
	float re = 0;
	for (i = 0; i < size; i++) {
		re += (float)arr[i] / size;
	}
	return re;

}

