package com.mudrax.narutoquiz

object Constant {

    const val FINAL_NAME : String = "username"
    const val COUNT_OF_ANS : String = "count"


    fun getallques() : ArrayList<Question>
    {
        val res = ArrayList<Question>()

        val ques1 = Question(1,"What Is the Clan of Sakura" ,
            R.drawable.sakuratwo, "Haruno" , "Momito" , "Hogimisho" , "Akimichi" , 1)
        val ques2 = Question(2,"Who created Akastsuki" ,
            R.drawable.akstsuki, "Tobi" , "Nagato" , "Madara" , "Yahiko" , 4)
        val ques3 = Question(3,"Age of Kakashi when he became Chonin was ?" ,
            R.drawable.questwo, "5 Years" , "6 Years" , "9 Years" , "11 Years" , 2)
        val ques4 = Question(4,"Youngest to become Jonin was ? " ,
            R.drawable.quesfour, "Minato" , "Itachi" , "Shisui" , "Orochimaru" , 3)
        val ques5 = Question(5,"Best ever Score in Academy was scored by?" ,
            R.drawable.academy, "Minato" , "Itachi" , "Shisui" , "Kakashi" , 1)
        val ques6 = Question(6,"Who is in the Picture shown below" ,
            R.drawable.questhree, "Danzo" , "Shisui" , "Iruka" , "Madara" , 2)
        val ques7 = Question(7,"Haku was killed by?" ,
            R.drawable.haku, "Kakashi" , "Naruto" , "Sasuke" , "Zabuza" , 1)
        val ques8 = Question(8,"Who was the First Shinobi to get Sage mode" ,
            R.drawable.sagemode, "Jiraya" , "Minato" , "Naruto" , "Hashirama" , 4)
        val ques9 = Question(9,"Ameyuri ringo was killed by ?" ,
            R.drawable.amiyuri, "Tobi" , "Might Guy" , "Omoi" , "None of them" , 4)
        val ques10 = Question(10,"The Shinobi who mastered all 5 Chakra Natures was?" ,
            R.drawable.chakra, "Hiruzen Saratobi" , "Tobirama" , "Sasuke" , "Kakashi" , 1)
        val ques11 = Question(11,"Who tricks Naruto into stealing a scroll in the first episode of the series?" ,
            R.drawable.scrolljpeg, "Iruka" , "Mitsuki" , "Mizuki" , "Mado" , 3)
        val ques12 = Question(12,"Which of Gamabunta's sons does Naruto accidentally summon during his fight against Gaara??" ,
            R.drawable.summon, "Gamikichi" , "Gamamoro" , "Gamatatsu" , "Hoshimoro" , 1)
        val ques13 = Question(13,"Akatsuki's initial plans were to have" ,
            R.drawable.akatsukiplans, "Make seprate village" , "Create Infinite Tsukuyomi" , "World peace" , "None" , 3)
        val ques14 = Question(14,"Sasuke was taken to orochimaru by ?" ,
            R.drawable.kidnap, "Sand Ninjas" , "Leaf ninja" , "Cloud ninjas" , "Sound ninjas" , 4)
        val ques15 = Question(15,"When Minato rescued kushina she was taken from leaf to which village ?" ,
            R.drawable.minato, "Village hidden in Cloud" , "Hidden stone village" , "Sound village" , "Sand village" , 1)


        res.add(ques1)
        res.add(ques2)
        res.add(ques3)
        res.add(ques4)
        res.add(ques5)
        res.add(ques6)
        res.add(ques7)
        res.add(ques8)
        res.add(ques9)
        res.add(ques10)
        res.add(ques11)
        res.add(ques12)
        res.add(ques13)
        res.add(ques14)
        res.add(ques15)

        return res
    }
}
