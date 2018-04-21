#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <windows.h>
void instruction();
int validate(char *sInput);
void input(char **sInput);
void creatAnswer(char *sOutput);
int calPerfect(char *sInput,char *sOutput);
int calImperfect(char *sInput,char *sOutput);
int main()
{
    char *sInput,sOutput[]="5 5 5 3";
    instruction();
    //creatAnswer(sOutput);
    int chances=0,countPerfect=0,countImperfect=0;
    input(&sInput);
    puts(sOutput);
    clock_t begin=clock();
    SYSTEMTIME timeBegin;
    GetSystemTime(&timeBegin);
    while(1)
    {
        countPerfect=calPerfect(sInput,sOutput);
        countImperfect=calImperfect(sInput,sOutput);
        printf("You have %d perfect matches and %d imperfect matches.\n",countPerfect,countImperfect);
        chances++;
        if (chances==10) break;
        if (countPerfect==4) break;
        input(&sInput);
    }
    clock_t end=clock();
    SYSTEMTIME timeEnd;
    GetSystemTime(&timeEnd);

    int time=(end-begin)/CLOCKS_PER_SEC;
    int minute=time/60;
    int second=time-minute*60;
    if (countPerfect==4 && chances<10)
        printf("You have won the game in %d turns and %02d:%02d time!!!\n",chances,minute,second);
    else {
        printf("Sorry, you have exceeded the maximun number of turns. You lose.\n");
        printf("Here is the winning board: %s",sOutput);
    }
    return 0;
}
int calImperfect(char *sInput,char *sOutput)
{
    int checked[6]={0};
    int count=0,i,j;
    for (i=0;i<strlen(sInput);i+=2)
    if (sInput[i]!=sOutput[i])
        for (j=0;j<strlen(sOutput);j+=2)
        if (i!=j && sInput[i]==sOutput[j] && checked[sInput[j]-'0']==0)
        {
            checked[sInput[j]-'0']=1;
            count++;
            break;
        }
    return count;
}
int calPerfect(char *sInput,char *sOutput)
{
    int count=0,i;
    for (i=0;i<strlen(sInput);i+=2)
    if (sInput[i]==sOutput[i])
        count++;
    return count;
}
void creatAnswer(char *sOutput)
{
    srand(time(NULL));
    sOutput[0]=(rand()%6+'0');
    sOutput[2]=(rand()%6+'0');
    sOutput[4]=(rand()%6+'0');
    sOutput[6]=(rand()%6+'0');
}
void input(char **sInput)
{
    *sInput=(char *)malloc(sizeof(char));
    while(1)
    {
        *sInput=(char *)realloc(*sInput,strlen(sInput)*sizeof(char));
        gets(*sInput);
        *sInput=(char *)realloc(*sInput,strlen(sInput)*sizeof(char));
        int check=validate(*sInput);
        if (check==1) return;
        printf("Enter invalid guess, again:\n");
    }
}
void instruction()
{
    printf("Welcome to Mastermind!!!\n\n");
    printf("At each turn, you will enter your guess for the playing board.\n");
    printf("Each guess will have each number within the guess seperate by a space.\n");
    printf("When you are ready, enter you first guess.\n");
    printf("From that point on, you will be told how many perfect and imperfect matches you have.\n");
    printf("After this message, you should guess again. You have 10 chances, good luck!\n");
}
int validate(char *sInput)
{
    if (strlen(sInput)!=7) return 0;
    int validNum=0,validSpace=0;
    int i;
    for (i=0;i<strlen(sInput);i++)
    {
        if ('0'<=sInput[i] && sInput[i]<='5') validNum ++;
        else if (sInput[i]==' ') validSpace++;
        else return 0;
    }
    if (validNum==4 && validSpace==3) return 1;
    return 0;
}

