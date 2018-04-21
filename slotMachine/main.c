#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int rand_numb();// return random number
int Result(int a,int b,int c);//return point of a round game
void game(float *money);//game process
void playgame(float *money);// play a round game
void menu(float *money);//instruction to play game
void clean();//ignore enter key
int check(int min, int max, const char* error);//scan valid number from 1 to 3
int main(){
    float money;
	srand(time(NULL));
	FILE *sg = fopen("savegame.dat","rb");
	if(sg == NULL){
		money = 10;
		fclose(sg);
		game(&money);
	}
	else{
		fread(&money,1, sizeof(double),sg);
		fclose(sg);
		game(&money);
	}
}
int rand_numb(){
	return rand()%10;
}

int Result(int a,int b,int c){
	if(a==b && a==c) return 3;
	else if(a==b||a==c||b==c) return 1;
	else return 0;
}
void clean() {
    while (getchar() != '\n');
}
void game(float *money){
	int choose;
    //choose number and play game
	do{
		menu(money);
		printf("your select: ");
		choose = check(1, 3, "please enter number 1 to 3 : ");
		if(choose == 1){
			playgame(money);
		}
		else if(choose == 2){
			printf("Your money had saved!\n");
    		FILE *sg = fopen("savegame.dat","wb");
                        fwrite(money,1,sizeof(double),sg);
                        fclose(sg);
		}
		//write cash point to file

	} while(choose != 3 && *money != 0.0);

	// Cash out
	if(choose ==3){
		printf("Thank you for playing! You end with %.2f!",*money);
		*money=10;
		FILE *sg = fopen("savegame.dat","wb");
        fwrite(money,sizeof(double),1,sg);
        fclose(sg);
	}

	else {
		printf("You're out of money, see you next time!");
	}
}
void menu(float *money){
		printf("You have $%.2f\n",*money);
		printf("Choose one of the following menu option:\n");
		printf("1, Play the slot machine.\n");
		printf("2, Save game.\n");
		printf("3, Cash out.\n");
	}
//
void playgame(float *money){
	int a;
	int b;
	int c;
	int result;
	//creat random number
	a = rand_numb();
	b = rand_numb();
	c = rand_numb();
	printf("The slot machine shows [%d]-[%d]-[%d]\n",a,b,c);
	result = Result(a,b,c);
	if(result == 0){
		printf("Sorry you don't win anything.\n");
		*money -= 0.25;
	}
	else if(result ==1){
		printf("You win 50 cents\n");
		*money += 0.25;
	}
	else {
		printf("You win the big prize, $10.00\n");
		*money += 9.75;
	}
}

int check(int min, int max, const char* error) {
    int inputNumber;
    int check;
    char inputChar;
    while (1) {
        check = scanf("%d%c", &inputNumber, &inputChar);
        if (check != 2 || inputChar != '\n') {
        	clean();
            printf("%s", error);
        } else if (inputNumber < min || inputNumber > max)
            printf("Please input number form %d to %d: ", min, max);
        else return inputNumber;
    }
}
