package com.example.currency_converter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var CD: currencyData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userinp = findViewById<EditText>(R.id.userinput)
        val convrt = findViewById<Button>(R.id.btn)
        val spinner = findViewById<Spinner>(R.id.spn)

        val cur = arrayListOf("ada","aed","afn","all","amd","ang","aoa","ars","aud","awg","azn","bam","bbd","bch"
            ,"bdt","bgn","bhd","bif","bmd","bnb","bnd","bob","brl","bsd","btc","btn","bwp","byn","byr","bzd","cad"
            ,"cdf","chf","clf","clp","cny","cop","crc","cuc","cup","cve","czk","djf","dkk","doge","dop","dzd","egp"
            ,"ern","etb","etc","eth","eur","fjd","fkp","gbp","gel","ggp","ghs","gip","gmd","gnf","gtq","gyd","hkd"
            ,"hnl","hrk","htg","huf","idr","ils","imp","inr","iqd","irr","isk","jep","jmd","jod","jpy","kes","kgs"
            ,"khr","kmf","kpw","krw","kwd","kyd","kzt","lak","lbp","link","lkr","lrd","lsl","ltc","ltl","lvl","lyd"
            ,"mad","mdl","mga","mkd","mmk","mnt","mop","mro","mur","mvr","mwk","mxn","myr","mzn","nad","ngn","nio"
            ,"nok","npr","nzd","omr","pab","pen","pgk","php","pkr","pln","pyg","qar","ron","rsd","rub","rwf","sar"
            ,"sbd","scr","sdg","sek","sgd","shp","sll","sos","srd","std","svc","syp","szl","thb","theta","tjs","tmt"
            ,"tnd","top","trx","try","ttd","twd","tzs","uah","ugx","usd","usdt","uyu","uzs","vef","vnd","vuv","wst"
            ,"xaf","xag","xau","xcd","xdr","xlm","xof","xpf","xrp","yer","zar","zmk","zmw")

        var selected: Int = 0

        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cur)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selected = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        convrt.setOnClickListener {

            var sel = userinp.text.toString()
            var currency: Double = sel.toDouble()

            getCurrency(onResult = {
                CD = it
//                CD?.sar.
                spcal(currency,selected)
            })
        }

    }
    private fun spcal(currency:Double,selll:Int){
        when(selll) {
            0 -> disp(calc(CD?.sar?.ada?.toDouble(), currency));
            1 -> disp(calc(CD?.sar?.aed?.toDouble(), currency));
            2 -> disp(calc(CD?.sar?.afn?.toDouble(), currency));
            3 -> disp(calc(CD?.sar?.all?.toDouble(), currency));
            4 -> disp(calc(CD?.sar?.amd?.toDouble(), currency));
            5 -> disp(calc(CD?.sar?.ang?.toDouble(), currency));
            6 -> disp(calc(CD?.sar?.aoa?.toDouble(), currency));
            7 -> disp(calc(CD?.sar?.ars?.toDouble(), currency));
            8 -> disp(calc(CD?.sar?.aud?.toDouble(), currency));
            9 -> disp(calc(CD?.sar?.awg?.toDouble(), currency));
            10 -> disp(calc(CD?.sar?.azn?.toDouble(), currency));
            11 -> disp(calc(CD?.sar?.bam?.toDouble(), currency));
            12 -> disp(calc(CD?.sar?.bbd?.toDouble(), currency));
            13 -> disp(calc(CD?.sar?.bch?.toDouble(), currency));
            14 -> disp(calc(CD?.sar?.bdt?.toDouble(), currency));
            15 -> disp(calc(CD?.sar?.bgn?.toDouble(), currency));
            16 -> disp(calc(CD?.sar?.bhd?.toDouble(), currency));
            17 -> disp(calc(CD?.sar?.bif?.toDouble(), currency));
            18 -> disp(calc(CD?.sar?.bmd?.toDouble(), currency));
            19 -> disp(calc(CD?.sar?.bnb?.toDouble(), currency));
            20 -> disp(calc(CD?.sar?.bnd?.toDouble(), currency));
            21 -> disp(calc(CD?.sar?.bob?.toDouble(), currency));
            22 -> disp(calc(CD?.sar?.brl?.toDouble(), currency));
            23 -> disp(calc(CD?.sar?.bsd?.toDouble(), currency));
            24 -> disp(calc(CD?.sar?.btc?.toDouble(), currency));
            25 -> disp(calc(CD?.sar?.btn?.toDouble(), currency));
            26 -> disp(calc(CD?.sar?.bwp?.toDouble(), currency));
            27 -> disp(calc(CD?.sar?.byn?.toDouble(), currency));
            28 -> disp(calc(CD?.sar?.byr?.toDouble(), currency));
            29 -> disp(calc(CD?.sar?.bzd?.toDouble(), currency));
            30 -> disp(calc(CD?.sar?.cad?.toDouble(), currency));
            31 -> disp(calc(CD?.sar?.cdf?.toDouble(), currency));
            32 -> disp(calc(CD?.sar?.chf?.toDouble(), currency));
            33 -> disp(calc(CD?.sar?.clf?.toDouble(), currency));
            34 -> disp(calc(CD?.sar?.clp?.toDouble(), currency));
            35 -> disp(calc(CD?.sar?.cny?.toDouble(), currency));
            36 -> disp(calc(CD?.sar?.cop?.toDouble(), currency));
            37 -> disp(calc(CD?.sar?.crc?.toDouble(), currency));
            38 -> disp(calc(CD?.sar?.cuc?.toDouble(), currency));
            39 -> disp(calc(CD?.sar?.cup?.toDouble(), currency));
            40 -> disp(calc(CD?.sar?.cve?.toDouble(), currency));
            41 -> disp(calc(CD?.sar?.czk?.toDouble(), currency));
            42 -> disp(calc(CD?.sar?.djf?.toDouble(), currency));
            43 -> disp(calc(CD?.sar?.dkk?.toDouble(), currency));
            44 -> disp(calc(CD?.sar?.doge?.toDouble(), currency));
            45 -> disp(calc(CD?.sar?.dop?.toDouble(), currency));
            46 -> disp(calc(CD?.sar?.dzd?.toDouble(), currency));
            47 -> disp(calc(CD?.sar?.egp?.toDouble(), currency));
            48 -> disp(calc(CD?.sar?.ern?.toDouble(), currency));
            49 -> disp(calc(CD?.sar?.etb?.toDouble(), currency));
            50 -> disp(calc(CD?.sar?.etc?.toDouble(), currency));
            51 -> disp(calc(CD?.sar?.eth?.toDouble(), currency));
            52 -> disp(calc(CD?.sar?.eur?.toDouble(), currency));
            53 -> disp(calc(CD?.sar?.fjd?.toDouble(), currency));
            54 -> disp(calc(CD?.sar?.fkp?.toDouble(), currency));
            55 -> disp(calc(CD?.sar?.gbp?.toDouble(), currency));
            56 -> disp(calc(CD?.sar?.gel?.toDouble(), currency));
            57 -> disp(calc(CD?.sar?.ggp?.toDouble(), currency));
            58 -> disp(calc(CD?.sar?.ghs?.toDouble(), currency));
            59 -> disp(calc(CD?.sar?.gip?.toDouble(), currency));
            60 -> disp(calc(CD?.sar?.gmd?.toDouble(), currency));
            61 -> disp(calc(CD?.sar?.gnf?.toDouble(), currency));
            62 -> disp(calc(CD?.sar?.gtq?.toDouble(), currency));
            63 -> disp(calc(CD?.sar?.gyd?.toDouble(), currency));
            64 -> disp(calc(CD?.sar?.hkd?.toDouble(), currency));
            65 -> disp(calc(CD?.sar?.hnl?.toDouble(), currency));
            66 -> disp(calc(CD?.sar?.hrk?.toDouble(), currency));
            67 -> disp(calc(CD?.sar?.htg?.toDouble(), currency));
            68 -> disp(calc(CD?.sar?.huf?.toDouble(), currency));
            69 -> disp(calc(CD?.sar?.idr?.toDouble(), currency));
            70 -> disp(calc(CD?.sar?.ils?.toDouble(), currency));
            71 -> disp(calc(CD?.sar?.imp?.toDouble(), currency));
            72 -> disp(calc(CD?.sar?.inr?.toDouble(), currency));
            73 -> disp(calc(CD?.sar?.iqd?.toDouble(), currency));
            74 -> disp(calc(CD?.sar?.irr?.toDouble(), currency));
            75 -> disp(calc(CD?.sar?.isk?.toDouble(), currency));
            76 -> disp(calc(CD?.sar?.jep?.toDouble(), currency));
            77 -> disp(calc(CD?.sar?.jmd?.toDouble(), currency));
            78 -> disp(calc(CD?.sar?.jod?.toDouble(), currency));
            79 -> disp(calc(CD?.sar?.jpy?.toDouble(), currency));
            80 -> disp(calc(CD?.sar?.kes?.toDouble(), currency));
            81 -> disp(calc(CD?.sar?.kgs?.toDouble(), currency));
            82 -> disp(calc(CD?.sar?.khr?.toDouble(), currency));
            83 -> disp(calc(CD?.sar?.kmf?.toDouble(), currency));
            84 -> disp(calc(CD?.sar?.kpw?.toDouble(), currency));
            85 -> disp(calc(CD?.sar?.krw?.toDouble(), currency));
            86 -> disp(calc(CD?.sar?.kwd?.toDouble(), currency));
            87 -> disp(calc(CD?.sar?.kyd?.toDouble(), currency));
            88 -> disp(calc(CD?.sar?.kzt?.toDouble(), currency));
            89 -> disp(calc(CD?.sar?.lak?.toDouble(), currency));
            90 -> disp(calc(CD?.sar?.lbp?.toDouble(), currency));
            91 -> disp(calc(CD?.sar?.link?.toDouble(), currency));
            92 -> disp(calc(CD?.sar?.lkr?.toDouble(), currency));
            93 -> disp(calc(CD?.sar?.lrd?.toDouble(), currency));
            94 -> disp(calc(CD?.sar?.lsl?.toDouble(), currency));
            95 -> disp(calc(CD?.sar?.ltc?.toDouble(), currency));
            96 -> disp(calc(CD?.sar?.ltl?.toDouble(), currency));
            97 -> disp(calc(CD?.sar?.lvl?.toDouble(), currency));
            98 -> disp(calc(CD?.sar?.lyd?.toDouble(), currency));
            99 -> disp(calc(CD?.sar?.mad?.toDouble(), currency));
            100 -> disp(calc(CD?.sar?.mdl?.toDouble(), currency));
            101 -> disp(calc(CD?.sar?.mga?.toDouble(), currency));
            102 -> disp(calc(CD?.sar?.mkd?.toDouble(), currency));
            103 -> disp(calc(CD?.sar?.mmk?.toDouble(), currency));
            104 -> disp(calc(CD?.sar?.mnt?.toDouble(), currency));
            105 -> disp(calc(CD?.sar?.mop?.toDouble(), currency));
            106 -> disp(calc(CD?.sar?.mro?.toDouble(), currency));
            107 -> disp(calc(CD?.sar?.mur?.toDouble(), currency));
            108 -> disp(calc(CD?.sar?.mvr?.toDouble(), currency));
            109 -> disp(calc(CD?.sar?.mwk?.toDouble(), currency));
            110 -> disp(calc(CD?.sar?.mxn?.toDouble(), currency));
            111 -> disp(calc(CD?.sar?.myr?.toDouble(), currency));
            112 -> disp(calc(CD?.sar?.mzn?.toDouble(), currency));
            113 -> disp(calc(CD?.sar?.nad?.toDouble(), currency));
            114 -> disp(calc(CD?.sar?.ngn?.toDouble(), currency));
            115 -> disp(calc(CD?.sar?.nio?.toDouble(), currency));
            116 -> disp(calc(CD?.sar?.nok?.toDouble(), currency));
            117 -> disp(calc(CD?.sar?.npr?.toDouble(), currency));
            118 -> disp(calc(CD?.sar?.nzd?.toDouble(), currency));
            119 -> disp(calc(CD?.sar?.omr?.toDouble(), currency));
            120 -> disp(calc(CD?.sar?.pab?.toDouble(), currency));
            121 -> disp(calc(CD?.sar?.pen?.toDouble(), currency));
            122 -> disp(calc(CD?.sar?.pgk?.toDouble(), currency));
            123 -> disp(calc(CD?.sar?.php?.toDouble(), currency));
            124 -> disp(calc(CD?.sar?.pkr?.toDouble(), currency));
            125 -> disp(calc(CD?.sar?.pln?.toDouble(), currency));
            126 -> disp(calc(CD?.sar?.pyg?.toDouble(), currency));
            127 -> disp(calc(CD?.sar?.qar?.toDouble(), currency));
            128 -> disp(calc(CD?.sar?.ron?.toDouble(), currency));
            129 -> disp(calc(CD?.sar?.rsd?.toDouble(), currency));
            130 -> disp(calc(CD?.sar?.rub?.toDouble(), currency));
            131 -> disp(calc(CD?.sar?.rwf?.toDouble(), currency));
            132 -> disp(calc(CD?.sar?.sar?.toDouble(), currency));
            133 -> disp(calc(CD?.sar?.sbd?.toDouble(), currency));
            134 -> disp(calc(CD?.sar?.scr?.toDouble(), currency));
            135 -> disp(calc(CD?.sar?.sdg?.toDouble(), currency));
            136 -> disp(calc(CD?.sar?.sek?.toDouble(), currency));
            137 -> disp(calc(CD?.sar?.sgd?.toDouble(), currency));
            138 -> disp(calc(CD?.sar?.shp?.toDouble(), currency));
            139 -> disp(calc(CD?.sar?.sll?.toDouble(), currency));
            140 -> disp(calc(CD?.sar?.sos?.toDouble(), currency));
            141 -> disp(calc(CD?.sar?.srd?.toDouble(), currency));
            142 -> disp(calc(CD?.sar?.std?.toDouble(), currency));
            143 -> disp(calc(CD?.sar?.svc?.toDouble(), currency));
            144 -> disp(calc(CD?.sar?.syp?.toDouble(), currency));
            145 -> disp(calc(CD?.sar?.szl?.toDouble(), currency));
            146 -> disp(calc(CD?.sar?.thb?.toDouble(), currency));
            147 -> disp(calc(CD?.sar?.theta?.toDouble(), currency));
            148 -> disp(calc(CD?.sar?.tjs?.toDouble(), currency));
            149 -> disp(calc(CD?.sar?.tmt?.toDouble(), currency));
            150 -> disp(calc(CD?.sar?.tnd?.toDouble(), currency));
            151 -> disp(calc(CD?.sar?.top?.toDouble(), currency));
            152 -> disp(calc(CD?.sar?.trx?.toDouble(), currency));
            153 -> disp(calc(CD?.sar?.ttry?.toDouble(), currency));
            154 -> disp(calc(CD?.sar?.ttd?.toDouble(), currency));
            155 -> disp(calc(CD?.sar?.twd?.toDouble(), currency));
            156 -> disp(calc(CD?.sar?.tzs?.toDouble(), currency));
            157 -> disp(calc(CD?.sar?.uah?.toDouble(), currency));
            158 -> disp(calc(CD?.sar?.ugx?.toDouble(), currency));
            159 -> disp(calc(CD?.sar?.usd?.toDouble(), currency));
            160 -> disp(calc(CD?.sar?.usdt?.toDouble(), currency));
            161 -> disp(calc(CD?.sar?.uyu?.toDouble(), currency));
            162 -> disp(calc(CD?.sar?.uzs?.toDouble(), currency));
            163 -> disp(calc(CD?.sar?.vef?.toDouble(), currency));
            164 -> disp(calc(CD?.sar?.vnd?.toDouble(), currency));
            165 -> disp(calc(CD?.sar?.vuv?.toDouble(), currency));
            166 -> disp(calc(CD?.sar?.wst?.toDouble(), currency));
            167 -> disp(calc(CD?.sar?.xaf?.toDouble(), currency));
            168 -> disp(calc(CD?.sar?.xag?.toDouble(), currency));
            169 -> disp(calc(CD?.sar?.xau?.toDouble(), currency));
            170 -> disp(calc(CD?.sar?.xcd?.toDouble(), currency));
            171 -> disp(calc(CD?.sar?.xdr?.toDouble(), currency));
            172 -> disp(calc(CD?.sar?.xlm?.toDouble(), currency));
            173 -> disp(calc(CD?.sar?.xof?.toDouble(), currency));
            174 -> disp(calc(CD?.sar?.xpf?.toDouble(), currency));
            175 -> disp(calc(CD?.sar?.xrp?.toDouble(), currency));
            176 -> disp(calc(CD?.sar?.yer?.toDouble(), currency));
            177 -> disp(calc(CD?.sar?.zar?.toDouble(), currency));
            178 -> disp(calc(CD?.sar?.zmk?.toDouble(), currency));
            179 -> disp(calc(CD?.sar?.zmw?.toDouble(), currency));
        }

    }
    private fun disp(calc: Double) {

        val responseText = findViewById<View>(R.id.textView3) as TextView

        responseText.text = "result " + calc
    }

    private fun calc(i: Double?, sel: Double): Double {
        var s = 0.0
        if (i != null) {
            s = (i * sel)
        }
        return s
    }

    private fun getCurrency(onResult: (currencyData?) -> Unit) {
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        if (apiInterface != null) { apiInterface.getrates()?.enqueue(object : Callback<currencyData> {
                override fun onResponse(call: Call<currencyData>, response: Response<currencyData>) {
                    response.body()?.let { onResult(it) }

                }

                override fun onFailure(call: Call<currencyData>, t: Throwable) {

                    Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_SHORT).show();
                }

            })
        }
    }
}