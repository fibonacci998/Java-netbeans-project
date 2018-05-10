#include <stdio.h>
int main() {
    /* khai bao bien x va 2 bien con tro px, qx */
    int x, *px, *qx;
    px = &x;
    printf("Nhap gia tri cho vung nho px tro toi: ");
    scanf("%d", px);
    /* px la con tro nen khong viet scanf("%d", &px);  */

    qx = px; /* gan gia tri cua px cho qx, qx cun tro toi x*/

    printf("Vi tri cua bien x la %p \n", &x);
    printf("Vi tri cua bien x la %p \n", px);
    printf("Vi tri cua bien x la %p \n", qx);
    printf("Noi dung cua bien x la %d \n", x);
    printf("Noi dung cua bien x la %d \n", *px);
    printf("Noi dung cua bien x la %d \n", *qx);

    // tang gia tri cua o nho len, <=> x = x + 7826
    *px += 7826;
    printf("Noi dung cua bien x la %d \n", x);

    px++;
    /* cong them mot don vi cho px
     *  => px tro toi vung nho tiep theo
     */

    printf("Vi tri px tro toi la %p \n", px);

    return 0;
}
