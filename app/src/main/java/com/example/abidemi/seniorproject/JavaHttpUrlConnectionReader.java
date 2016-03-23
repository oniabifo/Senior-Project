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
 * A complete Java class that shows how to open a URL, then read data (text) from that URL,
 * HttpURLConnection class (in combination with an InputStreamReader and BufferedReader).
 *
 * @author alvin alexander, devdaily.com.
 *
 */
public class JavaHttpUrlConnectionReader
{

    public static String myUrl;
    public static String results;
    public static String arrayList;
    public static String date;
    public static String volume;
    public static String last_trade;
    public static String last_trade_time;
    public static String previous_close;
    public static String open;
    public static String day_high;
    public static String day_low;
    public static String change;
    public  String symbols;
    public static String name = date;

    public static List<List<String>> csvData = new ArrayList<List<String>>();
    public static void main(String[] args)
            throws Exception
    {
    }

    public String getData()
    {

        try
        {
            myUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=AVHI,SHLM,AHC,ATEN,AAC,AAON,AIR,AAN,ABAX,ABB,ABT,ABBV,ABY,ABGB,ABEO,ABEOW,ANF,FAX,IAF,CH,ABE,FCO,GCH,IF,ISL,JEQ,SGF,ABIL,ABILW,ABMD,ABM,AXAS,ACTG,ACHC,ACAD,AKR,ACST,AXDX,XLRN,ACN,ANCX,ACCO,ARAY,ACW,VXDN,VXUP,ACRX,ACET,AKAO,ACHN,ACIW,ACRS,ACU,ACNB,ACOR,ATV,AIII,ATNM,ACTS,ACPW,ATVI,ACTA,ATU,AYI,ACUR,ACXM,ADMS,ADMP,ADX,PEO,AE,ADAP,ADK^A,ADK,ADUS,AEY,AGRO,ADPT,IOTS,ADMA,ADBE,ADT,ADTN,ADRO,AAP,AAAP,WMS,AEIS,AITPU,AMD,ASX,AAV,ATE,ADXS,ADXSW,AVK,AGC,LCM,MAUI,YPRO,ACM,ANW,AEGR,AEGN,AEB,AED,AEG,AEH,AEK,AEHR,AMTX,AEPI,AER,AERI,ACY,HIVE,AJRD,ARO,AVAV,AEZS,AEMD,AET,AMG,MGR,AFMD,AFFX,AFL,AFSD,MITT,MITT^A,MITT^B,WGA,AGCO,AGEN,AGRX,A,AGYS,AGIO,GAS,AEM,ADC,GRO,AGU,AGFS,AGFSW,AIMT,AIRI,AL,AIRM,APD,AIRT,ATSG,AYR,ARG,AMCN,AIXG,AKS,AKAM,AKTX,AKBA,AKER,AKRX,ALP^O,ALG,AGI,ALRM,ALK,ALSK,AIN,AMRI,ALB,ALU,ABDC,AA,AA^,AA^B,ADHD,ALDR,ALDX,ALR,ALR^B,ALEX,ALX,ARE,ARE^D,ARE^E,AXU,ALXN,ALXA,BABA,ALCO,ALGN,ALIM,ALKS,Y,ATI,ABTX,ALGT,ALLE,AGN,AGN^A,ALE,AKP,ADS,AFOP,AIQ,AHGP,AFB,AOI,ARLP,AWF,AB,ACG,LNT,NCV,NCZ,ACV,NIE,NFJ,AHPI,AMOT,AWH,ALQA,ALSN,ALLT,MDRX,ALL,ALL^A,ALL^B,ALL^C,ALL^D,ALL^E,ALL^F,ALLY,ALLY^A,ALLY^B,AAU,AFAM,ALNY,BSI,ALJ,ALDW,AOSL,APT,GOOG,GOOGL,SMCP,ATEC,AGD,AWP,AOD,AAMC,ASPS,RESI,AIMC,MO,ACH,AMAG,AMRN,AMRK,AYA,AMZN,AMBC,AMBCW,AMBA,AMBR,ABEV,AMC,AMCX,DIT,DOX,AMFW,AMDA,AMED,UHAL,AEE,AMRC,ATAX,AMOV,AMX,AAL,AAT,AXL,ACC,AGNC,AGNCB,AGNCP,MTGE,MTGEP,ACSF,ACAS,GNOW,ADGE,AEO,AEP,AETI,AEL,AXP,AFCO,AFA,AFG,AFGE,AFGH,AFW,AMH,AMH^A,AMH^B,AMH^C,AMIC,AIG,AIG.WS,ALN,AMID,AMNB,ANAT,APEI,ARII,ARL,ARPI,AMRB,ASEI,AMS,AMSWA,AWR,AMSC,AMT,AMT^A,AMT^B,AVD,AWK,AMWD,CRMT,APU,AMP,ABCB,AMSF,ASRV,ASRVP,ABC,ATLO,AMGN,FOLD,ANFI,AMKR,AHS,AP,AMPH,APH,AMPE,BETR,APHB,AXR,AMSG,AMSGP,ASYS,AME,AFSI,AFSI^A,AFSI^B,AFSI^C,AFSI^D,AFSS,AFST,AMRS,ANAC,AEUA,APC,ANAD,ADI,ALOG,AVXL,ANCB,ABCW,ANDA,ANDAR,ANDAU,ANDAW,ANGI,ANGO,AU,BUD,ANIP,ANIK,AXE,NLY,NLY^A,NLY^C,NLY^D,ANSS,ATRS,AM,AR,ANTM,ANTX,ANTH,ANH,ANH^A,ANH^B,ANH^C,AON,ABAC,AXN,APA,AIV,AIV^A,AIV^Z,ATNY,APIC,APOG,ARI,ARI^A,APOL,APO,AIB,AINV,AIY,AMTG,AMTG^A,AFT,AIF,APPF,APLE,AAPL,ARCI,APDN,APDNW,AGTC,AIT,AMAT,AMCC,AAOI,AREX,APRI,ATR,APTO,WTR,AQMS,AQXP,AUMA,AUMAU,AUMAW,ARDM,ARLZ,ARMK,PETX,ABR,ABR^A,ABR^B,ABR^C,ABRN,ABUS,ARC,ARCW,ARCX,ABIO,RKDA,ARCB,MT,ACGL,ARH^C,ADM,APLP,AROC,ARCO,ACAT,ARDX,ASC,ARNA,AFC,ARCC,ARU,ACRE,ARDC,ARES,AGX,AGII,AGIIL,ARGS,ARIS,ARIA,ANET,ARKR,AI,AIC,AIW,ARMH,AHH,AMCO,ARR,ARR^A,ARR^B,AWI,ARTX,ARWA,ARWAR,ARWAU,ARWAW,ARQL,ARRY,HRT,ARRS,DWAT,ARW,AROW,ARWR,ARTNA,AJG,APAM,ARTW,ASA,AKG,ASBB,ABG,ASNA,ASND,ASCMA,ASTI,AHP,AHT,AHT^A,AHT^D,AHT^E,AINC,ASH,APB,APWC,GRR,ASML,ASPN,AHL,AHL^A,AHL^B,AHL^C,AZPN,ASMB,ASB,ASB.WS,ASB^B,ASB^C,AC,AIZ,AGO,AGO^B,AGO^E,AGO^F,ASFI,ASTE,AST,AF,AF^C,AZN,ALOT,ATRO,ASTC,ASUR,T,ATAI,ATRA,ATTO,ATHN,ATHX,AAPC,AAME,ACBI,ACFC,AT,ATNI,ATLC,AAWW,ATLS,AFH,ARP,ARP^D,ARP^E,TEAM,ATML,ATO,ATOS,ATRC,ATRI,ATTU,ATW,LIFE,AUO,AUBN,AUDC,AUPH,EARS,ABTL,ADSK,ATHM,ALV,ADP,AN,AZO,AAVL,AWX,AVB,AGR,AVNU,ACP,AVEO,AVY,AVXS,AVG,AVH,AVNW,AVID,AVGR,ASM,CAR,AVA,AV,AVV,AVT,AVP,AVX,AWRE,AXTA,ACLS,AXLL,AXS,AXS^C,AXS^D,AXGN,AXSM,AXTI,AZUR,AZZ&f=sl1d1t1c1ohgvp&e=.csv";
            results = doHttpUrlConnectionAction(myUrl);
            BufferedReader br = null;
            String line = "";
            String splitBy = ",";
            try
            {
                //List<List<String>> csvData = new ArrayList<List<String>>();
                br = new BufferedReader(new StringReader(results));
                while ((line = br.readLine()) != null)
                {
                    String[] splitted = line.split(",");
                    List<String> dataLine = new ArrayList<String>(splitted.length);
                    for (String data : splitted)
                    {
                        dataLine.add(data);
                    }
                    csvData.add(dataLine);
                }

                System.out.println();
                JSONObject json = new JSONObject();
                for(int i = 0; i < csvData.size(); i++)
                {

                    //arrayList= (csvData.get(0).get(0));
                    try {


                        json.put("Symbols", new JSONArray(Arrays.asList(csvData.get(0).get(0))));
                        json.put("Last_trade", new JSONArray(Arrays.asList(csvData.get(0).get(1))));
                        json.put("date", new JSONArray(Arrays.asList(csvData.get(0).get(2))));
                        json.put("last_trade_time", new JSONArray(Arrays.asList(csvData.get(0).get(3))));
                        json.put("Change", new JSONArray(Arrays.asList(csvData.get(0).get(4))));
                        json.put("open", new JSONArray(Arrays.asList(csvData.get(0).get(5))));
                        json.put("day_high", new JSONArray(Arrays.asList(csvData.get(0).get(6))));
                        json.put("day_low", new JSONArray(Arrays.asList(csvData.get(0).get(7))));
                        json.put("volume", new JSONArray(Arrays.asList(csvData.get(0).get(8))));
                        json.put("previous_close", new JSONArray(Arrays.asList(csvData.get(0).get(9))));
                        arrayList = json.toString();
                    }
                    catch (JSONException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try
                    {

                        JSONArray jsonarr = json.getJSONArray("Symbols");
                        JSONArray jsonarr2 = json.getJSONArray("Last_trade");
                        JSONArray jsonarr3 = json.getJSONArray("date");
                        JSONArray jsonarr4 = json.getJSONArray("last_trade_time");
                        JSONArray jsonarr5 = json.getJSONArray("Change");
                        JSONArray jsonarr6 = json.getJSONArray("open");
                        JSONArray jsonarr7 = json.getJSONArray("day_high");
                        JSONArray jsonarr10 = json.getJSONArray("day_low");
                        JSONArray jsonarr8 = json.getJSONArray("volume");
                        JSONArray jsonarr9 = json.getJSONArray("previous_close");

                        date = (String) jsonarr3.get(0);
                        date = date.replace("\"", "");

                        symbols = (String) jsonarr.get(0);
                        symbols = symbols.replace("\"", "");

                        last_trade_time = (String) jsonarr4.get(0);
                        last_trade_time = last_trade_time.replace("\"", "");

                        last_trade = (String) jsonarr2.get(0);
                        last_trade = last_trade.replace("\"", "");

                        change = (String) jsonarr5.get(0);
                        change = change.replace("\"", "");

                        day_high = (String) jsonarr7.get(0);
                        day_high = day_high.replace("\"", "");

                        open = (String) jsonarr6.get(0);
                        open = open.replace("\"", "");

                        volume = (String) jsonarr8.get(0);
                        volume = volume.replace("\"", "");

                        previous_close = (String) jsonarr9.get(0);
                        previous_close = previous_close.replace("\"", "");

                        day_low = (String) jsonarr10.get(0);
                        day_low = day_low.replace("\"", "");

                    }

                    catch (JSONException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println();
                Log.d("This is the json data", arrayList);
                Log.d("symbols", symbols);
                Log.d("date", date);
                Log.d("last_trade", last_trade);
                Log.d("last_trade_time", last_trade_time);
                Log.d("previous_close", previous_close);
                Log.d("day_high", day_high);
                Log.d("day_low", day_low);
                Log.d("open", open);
                Log.d("change", change);
                Log.d("volume", volume);

                return symbols;
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return arrayList;
        }
        catch (Exception e)
        {
            return e.toString();
        }
    }

    public String doHttpUrlConnectionAction(String desiredUrl)
            throws Exception {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(200 * 1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        } catch (MalformedURLException e) {
            throw new IOException("Invalid endpoint URL specified.", e);
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}