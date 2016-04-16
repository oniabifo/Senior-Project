package com.example.abidemi.seniorproject;
import android.app.Application;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import android.util.Log;
/**
 *
 *
 */
public class JavaHttpUrlConnectionReader
{

    public static String myUrl;
    public static String results;

    public String getData()
    {
        try
        {
            myUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=AVHI,SHLM,AHC,ATEN,AAC,ABIL,ABILW,ABMD,ABM,AXAS,ACTG,ACHC,ACAD,AKR,ACST,AXDX,XLRN,ACN,ANCX,ACCO,ARAY,ACW,VXDN,VXUP,ACRX,ACET,AKAO,ACHN,ACIW,ACRS,ACU,ACNB,ACOR,ATV,AIII,ATNM,ACTS,ACPW,ATVI,ACTA,ATU,AYI,ACUR,ACXM,ADMS,ADMP,ADX,PEO,AE,ADAP,ADK,ADUS,AEY,AGRO,ADPT,IOTS,ADMA,ADBE,ADT,ADTN,ADRO,AAP,AAAP,WMS,AEIS,AITPU,AMD,ASX,AAV,ATE,ADXS,ADXSW,AVK,AGC,LCM,MAUI,YPRO,ACM,ANW,AEGR,AEGN,AEB,AED,AEG,AEH,AEK,AEHR,AMTX,AEPI,AER,AERI,ACY,HIVE,AJRD,ARO,AVAV,AEZS,AEMD,AET,AMG,MGR,AFMD,AFFX,AFL,AFSD,MITT,WGA,AGCO,AGEN,AGRX,A,AGYS,AGIO,GAS,AEM,ADC,GRO,AGU,AGFS,AGFSW,AIMT,AIRI,AL,AIRM,APD,AIRT,ATSG,AYR,ARG,AMCN,AIXG,AKS,AKAM,AKTX,AKBA,AKER,AKRX,ALG,AGI,ALRM,ALK,ALSK,AIN,AMRI,ALB,ALU,ABDC,AA,ADHD,ALDR,ALDX,ALR,ALEX,ALX,ARE,AXU,ALXN,ALXA,BABA,ALCO,ALGN,ALIM,ALKS,Y,ATI,ABTX,ALGT,ALLE,AGN,ALE,AKP,ADS,AFOP,AIQ,AHGP,AFB,AOI,ARLP,AWF,AB,ACG,LNT,NCV,NCZ,ACV,NIE,NFJ,AHPI,AMOT,AWH,ALQA,ALSN,ALLT,MDRX,ALL,ALLY,AAU,AFAM,ALNY,BSI,ALJ,ALDW,AOSL,APT,GOOG,GOOGL,SMCP,ATEC,AGD,AWP,AOD,AAMC,ASPS,RESI,AIMC,MO,ACH,AMAG,AMRN,AMRK,AYA,AMZN,AMBC,AMBCW,AMBA,AMBR,ABEV,AMC,AMCX,DIT,DOX,AMFW,AMDA,AMED,UHAL,AEE,AMRC,ATAX,AMOV,AMX,AAL,AAT,AXL,ACC,AGNC,AGNCB,AGNCP,MTGE,MTGEP,ACSF,ACAS,GNOW,ADGE,AEO,AEP,AETI,AEL,AXP,AFCO,AFA,AFG,AFGE,AFGH,AFW,AMH,AMIC,AIG,AIG.WS,ALN,AMID,AMNB,ANAT,APEI,ARII,ARL,ARPI,AMRB,ASEI,AMS,AMSWA,AWR,AMSC,AMT,AVD,AWK,AMWD,CRMT,APU,AMP,ABCB,AMSF,ASRV,ASRVP,ABC,ATLO,AMGN,FOLD,ANFI,AMKR,AHS,AP,AMPH,APH,AMPE,BETR,APHB,AXR,AMSG,AMSGP,ASYS,AME,AFSI,AFSS,AFST,AMRS,ANAC,AEUA,APC,ANAD,ADI,ALOG,AVXL,ANCB,ABCW,ANDA,ANDAR,ANDAU,ANDAW,ANGI,ANGO,AU,BUD,ANIP,ANIK,AXE,NLY,ANSS,ATRS,AM,AR,ANTM,ANTX,ANTH,ANH,AON,ABAC,AXN,APA,AIV,ATNY,APIC,APOG,ARI,APOL,APO,AIB,AINV,AIY,AMTG,AFT,AIF,APPF,APLE,AAPL,ARCI,APDN,APDNW,AGTC,AIT,AMAT,AMCC,AAOI,AREX,APRI,ATR,APTO,WTR,AQMS,AQXP,AUMA,AUMAU,AUMAW,ARDM,ARLZ,ARMK,PETX,ABR,ABRN,ABUS,ARC,ARCW,ARCX,ABIO,RKDA,ARCB,MT,ACGL,ADM,APLP,AROC,ARCO,ACAT,ARDX,ASC,ARNA,AFC,ARCC,ARU,ACRE,ARDC,ARES,AGX,AGII,AGIIL,ARGS,ARIS,ARIA,ANET,ARKR,AI,AIC,AIW,ARMH,AHH,AMCO,ARR,AWI,ARTX,ARWA,ARWAR,ARWAU,ARWAW,ARQL,ARRY,HRT,ARRS,DWAT,ARW,AROW,ARWR,ARTNA,AJG,APAM,ARTW,ASA,AKG,ASBB,ALOT,ATRO,BDJ,EGF,FRA,BFO,BGT,BOE,BME,BAF,BKT,BGY,BKN,BTA,BZM,MHE,BIT,MUI,MNE,MUA,BPK,BKK,BIE,BBK,BBF,BYM,BFK,BLE,BTT,MEN,MUC,MUH,MHD,MFL,MUJ,MHN,MUE,MUS,MVT,MYC,MCA,MYD,MYF,MFT,MIY,MYJ,MYN,MPA,MQT,MYI,MQY,BLJ,BNJ,BNY,BLH,BQH,BSE,BFY,BCX,BST,BSD,BUI,BHV,BLK,BGB,BGX,BSL,ADRA,ADRD,ADRE,ADRU,BDR,BLMN,BLT,BCOR,BLBD,BUFF,BCRH,BBLU,BHBK,NILE,BLUE,BKEP,BKEPP,BXC,BPMC,BRG,ITEQ,STCK,BNCN,BWP,BOBE,BA,BOFI,WIFI,BCC,BOJA,BOKF,BONA,BCEI,BNSO,BOOT,BAH,BWA,SAM,BPFH,BPFHP,BPFHW,BXP,BSX,EPAY,BLVD,BLVDU,BRS,BTI,BRX,AVGO,BR,BSFT,BVSN,BYFC,BWEN,BRCD,BKD,BAM,BOXC,INF,HHY,BIP,BOI,BPY,BEP,HTR,BRKL,BRKS,BRO,BF.A,BF.B,BRT,BRKR,BC,BMTC,BLMT,BSQR,BT,BPL,BKE,BVN,BWLD,BBW,BLDR,BG,BUR,BURL,BWXT,CFFI,CJES,CHRW,BCR,BNK,CA,GYB,PFH,CAB,CABO,CVC,CBT,CCMP,COG,CACI,CDNS,CDZI,CAE,CACQ,CZR,CSTE,PRSS,CAI,CLBS,CLMS,CHY,CHI,CCD,CBM,CAC,CPT,CCJ,CAM,CPB,CCG,CAMT,CM,CNI,CNQ,CP,CSIQ,CGIX,CANF,CAJ,CMN,CPHC,CBNJ,CPLA,CBF,CCBG,COF,COF.WS,CPLP,CSU,CSWC,BXMT,CLA,CPTA,CLAC,CLACU,CLACW,CFFN,CAPN,CAPNW,CAPR,CMO,CPST,CARA,CRR,CARB,DKL,DK,DV,DXCM,DGSE,DHX,DHT,DHXM,DEO,DMND,DHIL,OC,PLKI,BPOP,BPOPM,BPOPN,PBIB,POR,PTLA,PKX,POST,PPS,POT,PBPB,PCH,POWL,POWI,PW,PSIX,POWR,PDBC,DWTR,IDLB,PRFZ,PAGG,PSAU,IPKW,LDRI,LALT,PNQI,QQQ,USLB,PSCD,PSCC,PSCE,PSCF,PSCH,PSCI,PSCT,PSCM,PSCU,PPG,PPX,PPL,PYS,PYT,PRAA,PRAH,PRAN,PX,PDS,APTS,PFBC,PJS,PLPC,PFBI,PINC,LENS,PGND,PBH,PVG,PRGX,PSMT,PBMD,PNRG,PRI,PPP,PRMW,PRIM,PFG,PGZ,PRZM,DNAI,PFPT,PRPH,PRQR,PRO,BIB,UBIO,TQQQ,ZBIO,SQQQ,BIS,PBB,PSEC,PB,PLX,PRTO,PTI,PRTA,PRLB,PSTG,PVCT,PVCT.WS,PWX,PVBC,PROV,PFS,PBIP,PFK,PJH,PRH,PRU,GHY,PUK,ISD,PSB,PSDV,PMD,TLK,PTC,PTCT,QUAD,KWR,QCOM,QSII,QBAK,QLYS,NX,PWR,QTM,QTWW,DGX,QRHC,STR,QUIK,QDEL,QPAC,QPACU,QPACW,QNST,RRD,RAX,RADA,RDCM,RDN,RLGT,ROIA,ROIAK,RSYS,RDUS,RDNT,RDWR,RAS,RFT,RFTA,RL,RMBS,RPT,RAND,RLOG,GOLD,RRC,RPD,RPTP,REE,RAVE,RAVN,RJD,RJF,RYAM,RYN,RTN,ROLL,RICK,RCMT,RMAX,RLOC,RDI,RDIB,RGSE,RELY,RLD,RNWK,RLGY,RP,O,UTES,UTG,DAX,UK,QYLD,RCON,REPH,RHT,RLH,RRGB,RDHL,REDF,RWT,REED,RBC,RGC,REG,REGN,RGNX,DFVL,DFVS,DLBL,DLBS,DTUL,DTUS,DTYL,DTYS,FLAT,STPP,TAPR,DGLD,DSLV,SLVO,TVIX,TVIZ,TCBIW,TXN,TPL,TXRH,TGH,TXT,TXTR,TFSL,TGTX,TTF,ABCO,AES,ANDE,TBBK,VCYT,VSTM,VER,VCEL,PAY,VRNT,VRSN,VRSK,VBTX,VRTV,VZ,VZA,VET,VRML,VSR,VSAR,VTNR,VRTX,VRTB,VIA,VIAB,VVI,VSAT,VIAV,VICL,VII,VICR,CIZ,CID,CIL,CFO,CFA,CSF,CDC,CDL,CSB,CSA,VBND,VUSE,VIDI,VDTH,VKTX,VBFC,VLGEA,VIP,VCO,VNCE,VMEM,VNOM,VIPS,VIRC,VA,VHC,VIRT,VSCP,VGI,VRTS,DCA,VRTU,V,VSH,VPG,VISN,VGZ,VSTO,VC,VTAE,VTL,VSI,VSLR,VVUS,VMW,VOC,VCRA,VOD,VNRX,VISI,VLTC,VG,VNO,VJET,VOXX,IAE,IHD,VOYA,IGA,IGD,IDE,IID,IRR,PPR,VYGR,VRNG,VSEC,VTTI,VTVT,VMC,WHLM,WVVI,WVVIP,WG,YNDX,YZC,YELP,YGE,ZBH,ZN,ZNWAA,ZBK,ZION,ZIONW,ZIONZ,ZIOP,ZIXI,ZOES,ZTS,ZGNX,ZSAN,ZUMZ,ZF,ZTR,ZYNE,ZNGA&f=sl1d1t1c1ohgvpn&e=.csv";
            results = doHttpUrlConnectionAction(myUrl);
//            System.out.println(results);
            return results;
        }
        catch (Exception e)
        {
            return e.toString();
        }
    }

    public String doHttpUrlConnectionAction(String desiredUrl)
            throws Exception
    {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        try
        {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(2000 * 1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        }
        catch (MalformedURLException e)
        {
            throw new IOException("Invalid endpoint URL specified.", e);
        }
        finally
        {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
    }
}