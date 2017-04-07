/* 
 * Copyright (c) 2006, Karl Helgason
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *    1. Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote
 *       products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package rasmus.fft.radix2; 
class OpFFTI32f4 { 
public static void calc(double[] d, int offset) { 
double d0=d[0+offset];
double d1=d[1+offset];
double d2=d[2+offset];
double d3=d[3+offset];
double d4=d[4+offset];
double d5=d[5+offset];
double d6=d[6+offset];
double d7=d[7+offset];
double d8=d[8+offset];
double d9=d[9+offset];
double d10=d[10+offset];
double d11=d[11+offset];
double d12=d[12+offset];
double d13=d[13+offset];
double d14=d[14+offset];
double d15=d[15+offset];
double d16=d[16+offset];
double d17=d[17+offset];
double d18=d[18+offset];
double d19=d[19+offset];
double d20=d[20+offset];
double d21=d[21+offset];
double d22=d[22+offset];
double d23=d[23+offset];
double d24=d[24+offset];
double d25=d[25+offset];
double d26=d[26+offset];
double d27=d[27+offset];
double d28=d[28+offset];
double d29=d[29+offset];
double d30=d[30+offset];
double d31=d[31+offset];
double d32=d[32+offset];
double d33=d[33+offset];
double d34=d[34+offset];
double d35=d[35+offset];
double d36=d[36+offset];
double d37=d[37+offset];
double d38=d[38+offset];
double d39=d[39+offset];
double d40=d[40+offset];
double d41=d[41+offset];
double d42=d[42+offset];
double d43=d[43+offset];
double d44=d[44+offset];
double d45=d[45+offset];
double d46=d[46+offset];
double d47=d[47+offset];
double d48=d[48+offset];
double d49=d[49+offset];
double d50=d[50+offset];
double d51=d[51+offset];
double d52=d[52+offset];
double d53=d[53+offset];
double d54=d[54+offset];
double d55=d[55+offset];
double d56=d[56+offset];
double d57=d[57+offset];
double d58=d[58+offset];
double d59=d[59+offset];
double d60=d[60+offset];
double d61=d[61+offset];
double d62=d[62+offset];
double d63=d[63+offset];
double tr;
double ti;
double n2w1r;
double n2w1i;
double m2ww1r;
double m2ww1i;
/* i = 0, j = 0 ----------------------------------------- */ 
tr=d2;
ti=d3;
d2=d0-tr;
d3=d1-ti;
d0=d0+tr;
d1=d1+ti;
n2w1r=d4;
n2w1i=d5;
m2ww1r=d6;
m2ww1i=d7;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d6=d2+ti;
d7=d3-tr;
d2=d2-ti;
d3=d3+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d4=d0-tr;
d5=d1-ti;
d0=d0+tr;
d1=d1+ti;
tr=d10;
ti=d11;
d10=d8-tr;
d11=d9-ti;
d8=d8+tr;
d9=d9+ti;
n2w1r=d12;
n2w1i=d13;
m2ww1r=d14;
m2ww1i=d15;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d14=d10+ti;
d15=d11-tr;
d10=d10-ti;
d11=d11+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d12=d8-tr;
d13=d9-ti;
d8=d8+tr;
d9=d9+ti;
tr=d18;
ti=d19;
d18=d16-tr;
d19=d17-ti;
d16=d16+tr;
d17=d17+ti;
n2w1r=d20;
n2w1i=d21;
m2ww1r=d22;
m2ww1i=d23;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d22=d18+ti;
d23=d19-tr;
d18=d18-ti;
d19=d19+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d20=d16-tr;
d21=d17-ti;
d16=d16+tr;
d17=d17+ti;
tr=d26;
ti=d27;
d26=d24-tr;
d27=d25-ti;
d24=d24+tr;
d25=d25+ti;
n2w1r=d28;
n2w1i=d29;
m2ww1r=d30;
m2ww1i=d31;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d30=d26+ti;
d31=d27-tr;
d26=d26-ti;
d27=d27+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d28=d24-tr;
d29=d25-ti;
d24=d24+tr;
d25=d25+ti;
tr=d34;
ti=d35;
d34=d32-tr;
d35=d33-ti;
d32=d32+tr;
d33=d33+ti;
n2w1r=d36;
n2w1i=d37;
m2ww1r=d38;
m2ww1i=d39;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d38=d34+ti;
d39=d35-tr;
d34=d34-ti;
d35=d35+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d36=d32-tr;
d37=d33-ti;
d32=d32+tr;
d33=d33+ti;
tr=d42;
ti=d43;
d42=d40-tr;
d43=d41-ti;
d40=d40+tr;
d41=d41+ti;
n2w1r=d44;
n2w1i=d45;
m2ww1r=d46;
m2ww1i=d47;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d46=d42+ti;
d47=d43-tr;
d42=d42-ti;
d43=d43+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d44=d40-tr;
d45=d41-ti;
d40=d40+tr;
d41=d41+ti;
tr=d50;
ti=d51;
d50=d48-tr;
d51=d49-ti;
d48=d48+tr;
d49=d49+ti;
n2w1r=d52;
n2w1i=d53;
m2ww1r=d54;
m2ww1i=d55;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d54=d50+ti;
d55=d51-tr;
d50=d50-ti;
d51=d51+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d52=d48-tr;
d53=d49-ti;
d48=d48+tr;
d49=d49+ti;
tr=d58;
ti=d59;
d58=d56-tr;
d59=d57-ti;
d56=d56+tr;
d57=d57+ti;
n2w1r=d60;
n2w1i=d61;
m2ww1r=d62;
m2ww1i=d63;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d62=d58+ti;
d63=d59-tr;
d58=d58-ti;
d59=d59+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d60=d56-tr;
d61=d57-ti;
d56=d56+tr;
d57=d57+ti;
/* i = 1, j = 0 ----------------------------------------- */ 
tr=d8;
ti=d9;
d8=d0-tr;
d9=d1-ti;
d0=d0+tr;
d1=d1+ti;
n2w1r=d16;
n2w1i=d17;
m2ww1r=d24;
m2ww1i=d25;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d24=d8+ti;
d25=d9-tr;
d8=d8-ti;
d9=d9+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d16=d0-tr;
d17=d1-ti;
d0=d0+tr;
d1=d1+ti;
tr=d40;
ti=d41;
d40=d32-tr;
d41=d33-ti;
d32=d32+tr;
d33=d33+ti;
n2w1r=d48;
n2w1i=d49;
m2ww1r=d56;
m2ww1i=d57;
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d56=d40+ti;
d57=d41-tr;
d40=d40-ti;
d41=d41+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d48=d32-tr;
d49=d33-ti;
d32=d32+tr;
d33=d33+ti;
/* i = 1, j = 2 ----------------------------------------- */ 
tr=(d10-d11)*(0.7071067811865475);
ti=(d10+d11)*(0.7071067811865476);
d10=d2-tr;
d11=d3-ti;
d2=d2+tr;
d3=d3+ti;
n2w1r=d18*(0.9238795325112867)-d19*(0.3826834323650898);
n2w1i=d18*(0.3826834323650898)+d19*(0.9238795325112867);
m2ww1r=d26*(0.38268343236508984)-d27*(0.9238795325112867);
m2ww1i=d26*(0.9238795325112867)+d27*(0.38268343236508984);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d26=d10+ti;
d27=d11-tr;
d10=d10-ti;
d11=d11+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d18=d2-tr;
d19=d3-ti;
d2=d2+tr;
d3=d3+ti;
tr=(d42-d43)*(0.7071067811865475);
ti=(d42+d43)*(0.7071067811865476);
d42=d34-tr;
d43=d35-ti;
d34=d34+tr;
d35=d35+ti;
n2w1r=d50*(0.9238795325112867)-d51*(0.3826834323650898);
n2w1i=d50*(0.3826834323650898)+d51*(0.9238795325112867);
m2ww1r=d58*(0.38268343236508984)-d59*(0.9238795325112867);
m2ww1i=d58*(0.9238795325112867)+d59*(0.38268343236508984);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d58=d42+ti;
d59=d43-tr;
d42=d42-ti;
d43=d43+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d50=d34-tr;
d51=d35-ti;
d34=d34+tr;
d35=d35+ti;
/* i = 1, j = 4 ----------------------------------------- */ 
tr=d12*(2.220446049250313E-16)-d13;
ti=d12+d13*(2.220446049250313E-16);
d12=d4-tr;
d13=d5-ti;
d4=d4+tr;
d5=d5+ti;
n2w1r=(d20-d21)*(0.7071067811865476);
n2w1i=(d20+d21)*(0.7071067811865475);
m2ww1r=(d28+d29)*(-0.7071067811865475);
m2ww1i=(d28-d29)*(0.7071067811865476);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d28=d12+ti;
d29=d13-tr;
d12=d12-ti;
d13=d13+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d20=d4-tr;
d21=d5-ti;
d4=d4+tr;
d5=d5+ti;
tr=d44*(2.220446049250313E-16)-d45;
ti=d44+d45*(2.220446049250313E-16);
d44=d36-tr;
d45=d37-ti;
d36=d36+tr;
d37=d37+ti;
n2w1r=(d52-d53)*(0.7071067811865476);
n2w1i=(d52+d53)*(0.7071067811865475);
m2ww1r=(d60+d61)*(-0.7071067811865475);
m2ww1i=(d60-d61)*(0.7071067811865476);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d60=d44+ti;
d61=d45-tr;
d44=d44-ti;
d45=d45+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d52=d36-tr;
d53=d37-ti;
d36=d36+tr;
d37=d37+ti;
/* i = 1, j = 6 ----------------------------------------- */ 
tr=(d14+d15)*(-0.7071067811865474);
ti=(d14-d15)*(0.7071067811865477);
d14=d6-tr;
d15=d7-ti;
d6=d6+tr;
d7=d7+ti;
n2w1r=d22*(0.38268343236508967)-d23*(0.9238795325112867);
n2w1i=d22*(0.9238795325112867)+d23*(0.38268343236508967);
m2ww1r=d30*(-0.9238795325112867)-d31*(-0.38268343236508956);
m2ww1i=d30*(-0.38268343236508956)+d31*(-0.9238795325112867);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d30=d14+ti;
d31=d15-tr;
d14=d14-ti;
d15=d15+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d22=d6-tr;
d23=d7-ti;
d6=d6+tr;
d7=d7+ti;
tr=(d46+d47)*(-0.7071067811865474);
ti=(d46-d47)*(0.7071067811865477);
d46=d38-tr;
d47=d39-ti;
d38=d38+tr;
d39=d39+ti;
n2w1r=d54*(0.38268343236508967)-d55*(0.9238795325112867);
n2w1i=d54*(0.9238795325112867)+d55*(0.38268343236508967);
m2ww1r=d62*(-0.9238795325112867)-d63*(-0.38268343236508956);
m2ww1i=d62*(-0.38268343236508956)+d63*(-0.9238795325112867);
tr=n2w1r-m2ww1r;
ti=n2w1i-m2ww1i;
d62=d46+ti;
d63=d47-tr;
d46=d46-ti;
d47=d47+tr;
tr=n2w1r+m2ww1r;
ti=n2w1i+m2ww1i;
d54=d38-tr;
d55=d39-ti;
d38=d38+tr;
d39=d39+ti;
tr=d32;
ti=d33;
d32=d0-tr;
d33=d1-ti;
d0=d0+tr;
d1=d1+ti;
tr=d34*(0.9807852804032304)-d35*(0.19509032201612825);
ti=d34*(0.19509032201612825)+d35*(0.9807852804032304);
d34=d2-tr;
d35=d3-ti;
d2=d2+tr;
d3=d3+ti;
tr=d36*(0.9238795325112867)-d37*(0.3826834323650897);
ti=d36*(0.3826834323650897)+d37*(0.9238795325112867);
d36=d4-tr;
d37=d5-ti;
d4=d4+tr;
d5=d5+ti;
tr=d38*(0.8314696123025452)-d39*(0.5555702330196022);
ti=d38*(0.5555702330196022)+d39*(0.8314696123025452);
d38=d6-tr;
d39=d7-ti;
d6=d6+tr;
d7=d7+ti;
tr=(d40-d41)*(0.7071067811865475);
ti=(d40+d41)*(0.7071067811865475);
d40=d8-tr;
d41=d9-ti;
d8=d8+tr;
d9=d9+ti;
tr=d42*(0.5555702330196022)-d43*(0.8314696123025451);
ti=d42*(0.8314696123025451)+d43*(0.5555702330196022);
d42=d10-tr;
d43=d11-ti;
d10=d10+tr;
d11=d11+ti;
tr=d44*(0.3826834323650897)-d45*(0.9238795325112866);
ti=d44*(0.9238795325112866)+d45*(0.3826834323650897);
d44=d12-tr;
d45=d13-ti;
d12=d12+tr;
d13=d13+ti;
tr=d46*(0.19509032201612825)-d47*(0.9807852804032302);
ti=d46*(0.9807852804032302)+d47*(0.19509032201612825);
d46=d14-tr;
d47=d15-ti;
d14=d14+tr;
d15=d15+ti;
tr=d48*(5.551115123125783E-17)-d49*(0.9999999999999998);
ti=d48*(0.9999999999999998)+d49*(5.551115123125783E-17);
d48=d16-tr;
d49=d17-ti;
d16=d16+tr;
d17=d17+ti;
tr=d50*(-0.19509032201612814)-d51*(0.9807852804032302);
ti=d50*(0.9807852804032302)+d51*(-0.19509032201612814);
d50=d18-tr;
d51=d19-ti;
d18=d18+tr;
d19=d19+ti;
tr=d52*(-0.38268343236508956)-d53*(0.9238795325112865);
ti=d52*(0.9238795325112865)+d53*(-0.38268343236508956);
d52=d20-tr;
d53=d21-ti;
d20=d20+tr;
d21=d21+ti;
tr=d54*(-0.555570233019602)-d55*(0.831469612302545);
ti=d54*(0.831469612302545)+d55*(-0.555570233019602);
d54=d22-tr;
d55=d23-ti;
d22=d22+tr;
d23=d23+ti;
tr=(d56+d57)*(-0.7071067811865472);
ti=(d56-d57)*(0.7071067811865474);
d56=d24-tr;
d57=d25-ti;
d24=d24+tr;
d25=d25+ti;
tr=d58*(-0.8314696123025449)-d59*(0.5555702330196021);
ti=d58*(0.5555702330196021)+d59*(-0.8314696123025449);
d58=d26-tr;
d59=d27-ti;
d26=d26+tr;
d27=d27+ti;
tr=d60*(-0.9238795325112863)-d61*(0.3826834323650896);
ti=d60*(0.3826834323650896)+d61*(-0.9238795325112863);
d60=d28-tr;
d61=d29-ti;
d28=d28+tr;
d29=d29+ti;
tr=d62*(-0.9807852804032299)-d63*(0.1950903220161282);
ti=d62*(0.1950903220161282)+d63*(-0.9807852804032299);
d62=d30-tr;
d63=d31-ti;
d30=d30+tr;
d31=d31+ti;
d[0+offset]=d0;
d[1+offset]=d1;
d[2+offset]=d2;
d[3+offset]=d3;
d[4+offset]=d4;
d[5+offset]=d5;
d[6+offset]=d6;
d[7+offset]=d7;
d[8+offset]=d8;
d[9+offset]=d9;
d[10+offset]=d10;
d[11+offset]=d11;
d[12+offset]=d12;
d[13+offset]=d13;
d[14+offset]=d14;
d[15+offset]=d15;
d[16+offset]=d16;
d[17+offset]=d17;
d[18+offset]=d18;
d[19+offset]=d19;
d[20+offset]=d20;
d[21+offset]=d21;
d[22+offset]=d22;
d[23+offset]=d23;
d[24+offset]=d24;
d[25+offset]=d25;
d[26+offset]=d26;
d[27+offset]=d27;
d[28+offset]=d28;
d[29+offset]=d29;
d[30+offset]=d30;
d[31+offset]=d31;
d[32+offset]=d32;
d[33+offset]=d33;
d[34+offset]=d34;
d[35+offset]=d35;
d[36+offset]=d36;
d[37+offset]=d37;
d[38+offset]=d38;
d[39+offset]=d39;
d[40+offset]=d40;
d[41+offset]=d41;
d[42+offset]=d42;
d[43+offset]=d43;
d[44+offset]=d44;
d[45+offset]=d45;
d[46+offset]=d46;
d[47+offset]=d47;
d[48+offset]=d48;
d[49+offset]=d49;
d[50+offset]=d50;
d[51+offset]=d51;
d[52+offset]=d52;
d[53+offset]=d53;
d[54+offset]=d54;
d[55+offset]=d55;
d[56+offset]=d56;
d[57+offset]=d57;
d[58+offset]=d58;
d[59+offset]=d59;
d[60+offset]=d60;
d[61+offset]=d61;
d[62+offset]=d62;
d[63+offset]=d63;
}
}
