// Name
// Course	csce3600
// Minor4 client


#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h>
 
int main()
{
	int sockfd = 0, n = 0;
	char recvBuff[1025];
	char sendBuff[1025];
	struct sockaddr_in serv_addr;
 
	memset(recvBuff, '0', sizeof(recvBuff));
	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
		printf("socket error\n");
		exit(EXIT_FAILURE);
	}
 
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_port = htons(5000);
	serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
 
	if (connect(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0)
	{
		printf("connect error\n");
		exit(EXIT_FAILURE);
	}

	printf("[CLIENT]: ");
	fgets(sendBuff,1024,stdin);

	write(sockfd, sendBuff, strlen(sendBuff));
 
	while ((n = read(sockfd, recvBuff, sizeof(recvBuff)-1)) > 0)
	{
		recvBuff[n] = 0;
		if (fputs(recvBuff, stdout) == EOF)
		{
			printf("fputs error\n");
		}
	}
 
	if (n < 0)
	{
		printf("read error\n");
	}
 
	return 0;
}