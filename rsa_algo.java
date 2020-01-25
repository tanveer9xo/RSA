package rsa;
import java.math.*;
import java.util.*;
class rsa_algo 
{
	 public static void mail(String args[])
	 {
		 Scanner sc = new Scanner(System.in);
		 int p,q,n,z,d=0,e,i;
		 System.out.println("Enter the number to be encrypted and decrypted");
		 int ToBeEncrypted=sc.nextInt();
		 double c;
		 
		 BigInteger Decrypted; 
		 
		 System.out.println("Enter a prime number p");
		 p=sc.nextInt();
		 System.out.println("Enter a prime number q");
		 q=sc.nextInt();
	 
		 n=p*q;
		 
		 z=(p-1)*(q-1);
		 
		 System.out.println("the value of z = "+z); 
	 
		 for(e=2;e<z;e++)
		 {
			 if(gcd(e,z)==1)            // e is public key exponent
			 { 
				 break;
			 }
		 }
		 System.out.println("the value of e = "+e); 
		 for(i=0;i<=9;i++)
		 {
			 int x=1+(i*z);
			 if(x%e==0)      //d is for private key exponent
			 {
				 d=x/e;
				 break;
			 }
		 }
		 System.out.println("the value of d = "+d); 
		 c=(Math.pow(ToBeEncrypted,e))%n;
		 
		 System.out.println("Encrypted message is : -");
		 System.out.println(c);
	               
		 BigInteger N = BigInteger.valueOf(n);
		 BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		 Decrypted = (C.pow(d)).mod(N);
		 
		 System.out.println("Derypted message is : -");
		 System.out.println(Decrypted);
	 
	 }
	 static int gcd(int e, int z)
	 {
		 if(e==0)
			 return z; 
		 else
			 return gcd(z%e,e);
	 }
}


