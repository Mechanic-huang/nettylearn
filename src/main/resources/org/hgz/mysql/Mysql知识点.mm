<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1521080957711" ID="ID_912078503" MODIFIED="1521080967602" TEXT="Mysql&#x77e5;&#x8bc6;&#x70b9;">
<node CREATED="1521082233797" ID="ID_1627694402" MODIFIED="1521082239030" POSITION="right" TEXT="&#x4e8b;&#x52a1;">
<node CREATED="1521082240145" ID="ID_360124174" MODIFIED="1521082260252" TEXT="1. &#x539f;&#x5b50;&#x6027;&#xff08;atomicity&#xff09;">
<node CREATED="1521082260253" ID="ID_1170094222" MODIFIED="1521082290214" TEXT="&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x5fc5;&#x987b;&#x662f;&#x4e00;&#x4e2a;&#x4e0d;&#x53ef;&#x5206;&#x5272;&#x7684;&#x6700;&#x5c0f;&#x5de5;&#x4f5c;&#x5355;&#x5143;&#xff0c;&#x8981;&#x4e0d;&#x5168;&#x90e8;&#x63d0;&#x4ea4;&#xff0c;&#x8981;&#x4e0d;&#x5168;&#x90e8;&#x5931;&#x8d25;&#x56de;&#x6eda;"/>
</node>
<node CREATED="1521082293345" ID="ID_1949000324" MODIFIED="1521082316797" TEXT="2. &#x4e00;&#x81f4;&#x6027;&#xff08;consisitency&#xff09;">
<node CREATED="1521082317873" ID="ID_1844919570" MODIFIED="1521082337581" TEXT="&#x6570;&#x636e;&#x5e93;&#x603b;&#x662f;&#x4ece;&#x4e00;&#x4e2a;&#x4e00;&#x81f4;&#x6027;&#x72b6;&#x6001;&#x5230;&#x53e6;&#x4e00;&#x4e2a;&#x4e00;&#x81f4;&#x6027;&#x72b6;&#x6001;&#x554a;"/>
</node>
<node CREATED="1521082339017" ID="ID_588802278" MODIFIED="1521082353262" TEXT="3. &#x9694;&#x79bb;&#x6027; &#xff08;isolation&#xff09;">
<node CREATED="1521082381529" ID="ID_602569976" MODIFIED="1521082407339" TEXT="&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x5728;&#x4fee;&#x6539;&#x63d0;&#x4ea4;&#x524d;&#xff0c;&#x5176;&#x4ed6;&#x4e8b;&#x52a1;&#x662f;&#x4e0d;&#x53ef;&#x89c1;&#x7684;"/>
</node>
<node CREATED="1521082353833" ID="ID_1040447606" MODIFIED="1521082379981" TEXT="4. &#x6301;&#x4e45;&#x6027;&#xff08;durability&#xff09;">
<node CREATED="1521082410257" ID="ID_1714141019" MODIFIED="1521082427150" TEXT="&#x4e00;&#x65e6;&#x4e8b;&#x52a1;&#x63d0;&#x4ea4;&#xff0c;&#x6240;&#x6709;&#x6570;&#x636e;&#x4f1a;&#x6301;&#x4e45;&#x5230;&#x786c;&#x76d8;"/>
</node>
</node>
<node CREATED="1521082555192" ID="ID_1471011195" MODIFIED="1521082557540" POSITION="right" TEXT="&#x9694;&#x79bb;&#x7ea7;&#x522b;">
<node CREATED="1521082559433" ID="ID_1302467643" MODIFIED="1521083248346" TEXT="READ UNCOMMITTED &#xff08;&#x672a;&#x63d0;&#x4ea4;&#x8bfb;/ &#x810f;&#x8bfb;&#xff09;">
<node CREATED="1521083021886" ID="ID_1101745140" MODIFIED="1521083082067" TEXT="&#x4e8b;&#x52a1;&#x4e2d;&#x7684;&#x4fee;&#x6539;&#xff0c;&#x5373;&#x4f7f;&#x6ca1;&#x63d0;&#x4ea4;&#xff0c;&#x5bf9;&#x5176;&#x4ed6;&#x4e8b;&#x52a1;&#x4e5f;&#x662f;&#x53ef;&#x89c1;&#x7684;&#x3002;&#x4e5f;&#x79f0;&#x810f;&#x8bfb;&#xff0c;&#x4e00;&#x822c;&#x5f88;&#x5c11;&#x4f7f;&#x7528;"/>
</node>
<node CREATED="1521083083783" ID="ID_945937967" MODIFIED="1521083257381" TEXT="READ COMMITTED &#xff08;&#x63d0;&#x4ea4;&#x8bfb;/ &#x4e0d;&#x53ef;&#x91cd;&#x590d;&#x8bfb;&#xff09;">
<node CREATED="1521083099694" ID="ID_879446049" MODIFIED="1521083542768" TEXT="&#x5927;&#x591a;&#x6570;&#x6570;&#x636e;&#x5e93;&#x7684;&#x9ed8;&#x8ba4;&#x9694;&#x79bb;&#x7ea7;&#x522b;&#xff08;MySQL&#x4e0d;&#x662f;&#xff09;&#xff0c;&#xa;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x5f00;&#x59cb;&#x65f6;&#x53ea;&#x80fd;&#x770b;&#x5230;&#x5df2;&#x7ecf;&#x63d0;&#x4ea4;&#x4e8b;&#x52a1;&#x505a;&#x7684;&#x4fee;&#x6539;&#x3002;&#xa;&#x6362;&#x53e5;&#x8bdd;&#xff0c;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x5f00;&#x59cb;&#x77e5;&#x9053;&#x63d0;&#x4ea4;&#x4e4b;&#x524d;&#xff0c;&#x6240;&#x505a;&#x7684;&#x4efb;&#x4f55;&#x4fee;&#x6539;&#x5bf9;&#x5176;&#x4ed6;&#x4e8b;&#x52a1;&#x90fd;&#x662f;&#x4e0d;&#x53ef;&#x89c1;&#x7684;&#x3002;&#xa;&#x8fd9;&#x4e2a;&#x7ea7;&#x522b;&#x6709;&#x65f6;&#x5019;&#x4e5f;&#x79f0;&#x4e0d;&#x53ef;&#x91cd;&#x590d;&#x8bfb;&#xff0c;&#x56e0;&#x4e3a;&#x4e24;&#x6b21;&#x6267;&#x884c;&#x540c;&#x6837;&#x7684;&#x67e5;&#x8be2;&#x53ef;&#x80fd;&#x67e5;&#x8be2;&#x7684;&#x7ed3;&#x679c;&#x4ea6;&#x4e00;&#x6837;"/>
</node>
<node CREATED="1521083259973" ID="ID_1333285192" MODIFIED="1521083301139" TEXT="REPEATALE READ (&#x53ef;&#x91cd;&#x590d;&#x8bfb;)">
<node CREATED="1521083313453" ID="ID_660786208" MODIFIED="1521083522248" TEXT="&#x8be5; &#x7ea7;&#x522b;&#x4fdd;&#x8bc1;&#xff0c;&#x591a;&#x6b21;&#x8bfb;&#x53d6;&#x7684;&#x8bb0;&#x5f55;&#x7ed3;&#x679c;&#x662f;&#x4e00;&#x81f4;&#x7684;&#xff0c;&#x4f46;&#x662f;&#x65e0;&#x6cd5;&#x89e3;&#x51b3;&#x5e7b;&#x8bfb;&#x95ee;&#x9898;&#xff0c;&#xa;&#x6240;&#x8c13;&#x5e7b;&#x8bfb;&#xff1a; &#x67d0;&#x4e2a;&#x4e8b;&#x52a1;&#x5728;&#x8bfb;&#x53d6;&#x67d0;&#x4e2a;&#x8303;&#x56f4;&#x7684;&#x6570;&#x636e;&#xff0c;&#x53e6;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x5728;&#x8be5;&#x8303;&#x56f4;&#x63d2;&#x5165;&#x4e86;&#x6570;&#x636e;&#xff0c;&#xa;&#x5f53;&#x4e4b;&#x524d;&#x7684;&#x4e8b;&#x52a1;&#x518d;&#x8bfb;&#x53d6;&#x8303;&#x56f4;&#x6570;&#x636e;&#x65f6;&#x5c31;&#x4f1a;&#x4ea7;&#x751f;&#x5e7b;&#x8bfb;&#x3002;InnoDB &#x548c; XtraDB &#x5b58;&#x50a8;&#x5f15;&#x64ce;&#x901a;&#x8fc7;&#x591a;&#x7248;&#x672c;&#x63a7;&#x5236;MVCC&#xa;&#x89e3;&#x51b3;&#x4e86;&#x5e7b;&#x8bfb;&#x95ee;&#x9898;"/>
</node>
<node CREATED="1521083552189" ID="ID_797239458" MODIFIED="1521083582077" TEXT="SERIALIZABLE &#xff08;&#x4e32;&#x884c;&#x5316;&#xff09;">
<node CREATED="1521083582077" ID="ID_1618639016" MODIFIED="1521083672167" TEXT="&#x6700;&#x9ad8;&#x7684;&#x9694;&#x79bb;&#x7ea7;&#x522b;&#x3002;&#x5b83;&#x901a;&#x8fc7;&#x5c06;&#x4e8b;&#x52a1;&#x4e32;&#x884c;&#x5316;&#xff0c;&#x907f;&#x514d;&#x4e86;&#x4e4b;&#x524d;&#x7684;&#x5e7b;&#x8bfb;&#x95ee;&#x9898;&#xff0c;&#x4f1a;&#x5bf9;&#x64cd;&#x4f5c;&#x7684;&#x6bcf;&#x4e00;&#x884c;&#x6570;&#x636e;&#x90fd;&#x52a0;&#x9501;"/>
</node>
</node>
<node CREATED="1521083773100" ID="ID_1304102266" MODIFIED="1521083774794" POSITION="right" TEXT="&#x6b7b;&#x9501;">
<node CREATED="1521083775707" ID="ID_1463899321" MODIFIED="1521083794040" TEXT="&#x4e24;&#x4e2a;&#x6216;&#x8005;&#x591a;&#x4e2a;&#x4e8b;&#x52a1;&#x5728;&#x540c;&#x4e00;&#x8d44;&#x6e90;&#x4e0a;&#x76f8;&#x4e92;&#x5360;&#x7528;"/>
<node CREATED="1521083805803" ID="ID_107080096" MODIFIED="1521083808584" TEXT="&#x89e3;&#x51b3;&#x65b9;&#x6848;">
<node CREATED="1521083809332" ID="ID_319383822" MODIFIED="1521083822080" TEXT="1. &#x6b7b;&#x9501;&#x68c0;&#x6d4b;&#xff0c;&#x6b7b;&#x9501;&#x8d85;&#x65f6;&#x673a;&#x5236;"/>
<node CREATED="1521083822459" ID="ID_1760628815" MODIFIED="1521083842575" TEXT="InnoDB&#x5904;&#x7406;&#x65b9;&#x6cd5;">
<node CREATED="1521083843387" ID="ID_1669389289" MODIFIED="1521084022396" TEXT="&#x5c06;&#x6301;&#x6709;&#x6700;&#x5c11;&#x884c;&#x7ea7;&#x6392;&#x4ed6;&#x9501;&#x7684;&#x4e8b;&#x52a1;&#x8fdb;&#x884c;&#x56de;&#x6eda;"/>
</node>
</node>
</node>
<node CREATED="1521084023291" ID="ID_1000567826" MODIFIED="1521092653612" POSITION="right" TEXT="MySQL&#x4e2d;&#x7684;&#x4e8b;&#x52a1;">
<node CREATED="1521084043314" ID="ID_357036834" MODIFIED="1521084067210" TEXT="&#x81ea;&#x52a8;&#x6a21;&#x5f0f;">
<node CREATED="1521084193426" ID="ID_1015133226" MODIFIED="1521084310908" TEXT="&#x9ed8;&#x8ba4;&#x6a21;&#x5f0f;&#xff0c;&#x5982;&#x679c;&#x4e0d;&#x662f;&#x663e;&#x793a;&#x5f00;&#x59cb;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#xff0c;&#x5219;&#x6bcf;&#x4e2a;&#x67e5;&#x8be2;&#x90fd;&#x88ab;&#x5f53;&#x505a;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x6267;&#x884c;&#x63d0;&#x4ea4;&#x64cd;&#x4f5c;"/>
</node>
<node CREATED="1521084311834" ID="ID_1967465245" MODIFIED="1521084322582" TEXT="&#x5728;&#x4e8b;&#x52a1;&#x4e2d;&#x6df7;&#x5408;&#x4f7f;&#x7528;&#x5b58;&#x50a8;&#x5f15;&#x64ce;">
<node CREATED="1521084323449" ID="ID_675623883" MODIFIED="1521084361956" TEXT="&#x4e8b;&#x52a1;&#x662f;&#x7531;&#x4e0b;&#x5c42;&#x7684;&#x5b58;&#x50a8;&#x5f15;&#x64ce;&#x5b9e;&#x73b0;&#x7684;&#xff0c;&#x6240;&#x4ee5;&#x5728;&#x540c;&#x4e00;&#x4e2a;&#x4e8b;&#x52a1;&#x4e2d;&#x4f7f;&#x7528;&#x4e0d;&#x540c;&#x7684;&#x5b58;&#x50a8;&#x5f15;&#x64ce;&#x662f;&#x4e0d;&#x53ef;&#x9760;&#x7684;"/>
</node>
<node CREATED="1521084406505" ID="ID_1971002424" MODIFIED="1521084412901" TEXT="&#x9690;&#x5f0f;&#x548c;&#x663e;&#x793a;&#x9501;&#x5b9a;">
<node CREATED="1521085006018" ID="ID_1580323950" MODIFIED="1521085014523" TEXT="&#x9690;&#x5f0f;&#x9501;&#x5b9a;">
<node CREATED="1521084833807" ID="ID_924202531" MODIFIED="1521084917674" TEXT="&#x5728;&#x4e8b;&#x52a1;&#x6267;&#x884c;&#x4e2d;&#xff0c;&#x968f;&#x65f6;&#x90fd;&#x53ef;&#x4ee5;&#x6267;&#x884c;&#x9501;&#x5b9a;&#xff0c;&#xa;&#x9501;&#x53ea;&#x6709;&#x6267;&#x884c;commit&#x6216;&#x8005;rollback&#x7684;&#x65f6;&#x5019;&#x624d;&#x4f1a;&#x91ca;&#x653e;&#xff0c;&#xa;&#x5e76;&#x4e14;&#x6240;&#x6709;&#x7684;&#x9501;&#x90fd;&#x662f;&#x540c;&#x4e00;&#x65f6;&#x523b;&#x624d;&#x4f1a;&#x91ca;&#x653e;"/>
</node>
<node CREATED="1521085018959" ID="ID_1514898381" MODIFIED="1521091021388" TEXT="&#x663e;&#x793a;&#x9501;&#x5b9a;">
<node CREATED="1521085032183" ID="ID_645110102" MODIFIED="1521090907177">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      SELECT ... LOCK IN SHARE MODE
    </p>
    <p>
      SELECT ... FOR UPDATE
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1521090910193" ID="ID_7796408" MODIFIED="1521090994636" TEXT="&#x670d;&#x52a1;&#x5668;&#x5c42;&#x5b9e;&#x73b0;&#x4e0e;&#x5177;&#x4f53;&#x7684;&#x5b58;&#x50a8;&#x5f15;&#x64ce;&#x65e0;&#x5173;&#xff0c;&#x4f46;&#x662f;&#x4ee3;&#x66ff;&#x4e0d;&#x4e86;&#x4e8b;&#x52a1;"/>
<node CREATED="1521090996031" ID="ID_593852461" MODIFIED="1521091016398" TEXT="&#x4e0d;&#x8981;&#x4f7f;&#x7528;&#x663e;&#x793a;&#x9501;&#x8868;"/>
</node>
</node>
</node>
<node CREATED="1521091028033" ID="ID_1635667793" MODIFIED="1521092663703" POSITION="right" TEXT="&#x591a;&#x7248;&#x672c;&#x5e76;&#x53d1;&#x63a7;&#x5236;&#xff08;MVCC&#xff09;">
<node CREATED="1521091071185" ID="ID_348759669" MODIFIED="1524013074101" TEXT="&#x8bf4;&#x660e;&#xff1a;  &#x53ef;&#x4ee5;&#x7b80;&#x5355;&#x7684;&#x7406;&#x89e3;MVCC&#x662f;&#x884c;&#x7ea7;&#x9501;&#x7684;&#x7b80;&#x5355;&#x53d8;&#x79cd;&#xff0c;&#xa;&#x4f46;&#x662f;&#x4ed6;&#x5728;&#x5f88;&#x591a;&#x60c5;&#x51b5;&#x4e0b;&#x907f;&#x514d;&#x4e86;&#x52a0;&#x9501;&#x64cd;&#x4f5c;&#xff0c;&#xa;&#x5f00;&#x9500;&#x66f4;&#x4f4e;&#xff0c;&#x867d;&#x7136;&#x5b9e;&#x73b0;&#x673a;&#x5236;&#x4e0d;&#x76f8;&#x540c;&#xff0c;&#x4f46;&#x5927;&#x591a;&#x6570;&#x90fd;&#x5b9e;&#x73b0;&#x4e86;&#x975e;&#x963b;&#x585e;&#x7684;&#x8bfb;&#x64cd;&#x4f5c;&#xff0c;&#xa;&#x5199;&#x64cd;&#x4f5c;&#x4e5f;&#x53ea;&#x9501;&#x5b9a;&#x5fc5;&#x8981;&#x7684;&#x884c;"/>
<node CREATED="1521091229001" ID="ID_750543896" MODIFIED="1521091262020" TEXT="&#x6839;&#x636e;&#x4e8b;&#x52a1;&#x7684;&#x5f00;&#x59cb;&#x65f6;&#x95f4;&#x7684;&#x4e0d;&#x540c;&#xff0c;&#x6bcf;&#x4e2a;&#x4e8b;&#x52a1;&#x5bf9;&#x540c;&#x4e00;&#x5f20;&#x8868;&#xff0c;&#x540c;&#x65f6;&#x770b;&#x5230;&#x7684;&#x6570;&#x636e;&#x53ef;&#x80fd;&#x4e0d;&#x4e00;&#x6837;"/>
<node CREATED="1521091329535" ID="ID_1345465633" MODIFIED="1524013202134" TEXT="&#x4e0d;&#x540c;&#x5b58;&#x50a8;&#x5f15;&#x64ce;&#x5bf9;MVCC&#x7684;&#x5b9e;&#x73b0;&#x90fd;&#x6709;&#x6240;&#x4e0d;&#x540c;">
<node CREATED="1521091347247" ID="ID_393727798" MODIFIED="1521091353212" TEXT="&#x4e50;&#x89c2;&#x5e76;&#x53d1;&#x63a7;&#x5236;"/>
<node CREATED="1521091353487" ID="ID_253091798" MODIFIED="1521091357524" TEXT="&#x60b2;&#x89c2;&#x5e76;&#x53d1;&#x63a7;&#x5236;"/>
</node>
<node CREATED="1521091427175" ID="ID_394298033" MODIFIED="1521091437235" TEXT="InnoDB&#x5b9e;&#x73b0;MVCC">
<node CREATED="1521091438230" ID="ID_1721963248" MODIFIED="1521092119258">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#35828;&#26126;&#65306;&#26159;&#26681;&#25454;&#27599;&#26465;&#35760;&#24405;&#21518;&#38754;&#20445;&#23384;&#20004;&#20010;&#38544;&#34255;&#21015;&#23454;&#29616;&#30340;&#65292;
    </p>
    <p>
      &#36825;&#20004;&#20010;&#21015;&#65292;&#19968;&#20010;&#20445;&#23384;&#34892;&#30340;&#21019;&#24314;&#26102;&#38388;&#65292;&#19968;&#20010;&#20445;&#23384;&#34892;&#30340;&#36807;&#26399;&#26102;&#38388;&#65288;&#21024;&#38500;&#26102;&#38388;&#65289;
    </p>
    <p>
      &#24403;&#28982;&#23384;&#20648;&#30340;&#19981;&#26159;&#26102;&#38388;&#65292;&#32780;&#26159;&#31995;&#32479;&#29256;&#26412;&#21495;&#65288;system version number&#65289;&#12290;
    </p>
    <p>
      &#27599;&#24320;&#22987;&#19968;&#20010;&#26032;&#30340;&#20107;&#21153;&#65292;&#31995;&#32479;&#29256;&#26412;&#21495;&#23601;&#20250;&#33258;&#21160;&#22686;&#21152;&#65292;&#20107;&#21153;&#24320;&#22987;&#30340;&#29256;&#26412;&#21495;&#23601;&#20250;&#25104;&#20026;&#20107;&#21153;&#30340;&#29256;&#26412;&#21495;&#65292;&#29992;&#20110;&#19982;&#26597;&#35810;&#21040;&#27599;&#26465;&#35760;&#24405;&#30340;&#29256;&#26412;&#21495;&#36827;&#34892;&#27604;&#36739;
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1521092123604" ID="ID_384425497" MODIFIED="1521092143016" TEXT="REPEATABLE READ">
<node CREATED="1521092144179" ID="ID_1991870615" MODIFIED="1521092162841" TEXT="SELECT">
<node CREATED="1521092163204" ID="ID_1954618453" MODIFIED="1521092267423" TEXT="InnoDB&#x53ea;&#x67e5;&#x627e;&#x7248;&#x672c;&#x65e9;&#x4e8e;&#x5f53;&#x524d;&#x4e8b;&#x52a1;&#x7248;&#x672c;&#x7684;&#x6570;&#x636e;&#x884c;&#xff08;&#x884c;&#x7684;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x5c0f;&#x4e8e;&#x7b49;&#x4e8e;&#x4e8b;&#x52a1;&#x7684;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#xff09;&#xff0c;&#xa;&#x8fd9;&#x6837;&#x4fdd;&#x8bc1;&#x4e8b;&#x52a1;&#x8bfb;&#x53d6;&#x7684;&#x884c;&#xff0c;&#x8981;&#x4e48;&#x5728;&#x4e8b;&#x52a1;&#x5f00;&#x59cb;&#x524d;&#x5df2;&#x7ecf;&#x5b58;&#x5728;&#xff0c;&#x8981;&#x4e48;&#x662f;&#x8bfb;&#x53d6;&#x4e8b;&#x52a1;&#x5f53;&#x524d;&#x63d2;&#x5165;&#x6216;&#x8005;&#x4fee;&#x6539;&#x7684;"/>
<node CREATED="1521092281300" ID="ID_1556066708" MODIFIED="1524013309521" TEXT="&#x884c;&#x7684;&#x5220;&#x9664;&#x7248;&#x672c;&#x8981;&#x4e48;&#x6ca1;&#x5b9a;&#x4e49;&#xff0c;&#x8981;&#x4e48;&#x5927;&#x4e8e;&#x5f53;&#x524d;&#x4e8b;&#x52a1;&#x7248;&#x672c;&#x53f7;&#x3002;&#x4fdd;&#x8bc1;&#x4e8b;&#x52a1;&#x7684;&#x8bfb;&#x53d6;&#x5230;&#x7684;&#x884c;&#xff0c;&#x5728;&#x4e8b;&#x52a1;&#x5f00;&#x59cb;&#x4e4b;&#x524d;&#x672a;&#x88ab;&#x5220;&#x9664;"/>
</node>
<node CREATED="1521092329652" ID="ID_12326332" MODIFIED="1521092337321" TEXT="INSERT">
<node CREATED="1521092344771" ID="ID_62415746" MODIFIED="1521092412432" TEXT="InnoDB &#x4e3a;&#x65b0;&#x63d2;&#x5165;&#x7684;&#x6bcf;&#x4e00;&#x884c;&#x4fdd;&#x5b58;&#x5f53;&#x524d;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x4f5c;&#x4e3a;&#x884c;&#x7248;&#x672c;&#x53f7;"/>
</node>
<node CREATED="1521092414747" ID="ID_854934028" MODIFIED="1521092418063" TEXT="DELETE">
<node CREATED="1521092419067" ID="ID_61744077" MODIFIED="1521092435328" TEXT="&#x4fdd;&#x5b58;&#x5f53;&#x524d;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x4f5c;&#x4e3a;&#x5220;&#x9664;&#x7248;&#x672c;&#x53f7;"/>
</node>
<node CREATED="1521092436475" ID="ID_127996509" MODIFIED="1521092443719" TEXT="UPDATE">
<node CREATED="1521092445267" ID="ID_1406412655" MODIFIED="1521092510061" TEXT="InnoDB &#x4f1a;&#x4e3a;&#x63d2;&#x5165;&#x4e00;&#x884c;&#x65b0;&#x7eaa;&#x5f55;&#xff0c;&#x4fdd;&#x5b58;&#x5f53;&#x524d;&#x7684;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x4f5c;&#x4e3a;&#x884c;&#x7248;&#x672c;&#x53f7;&#xff0c;&#xa;&#x540c;&#x65f6;&#x4fdd;&#x5b58;&#x5f53;&#x524d;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x5230;&#x539f;&#x6765;&#x7684;&#x884c;&#x5220;&#x9664;&#x6807;&#x8bc6;"/>
</node>
</node>
<node CREATED="1521092519596" ID="ID_817093877" MODIFIED="1521092543183" TEXT="&#x4fdd;&#x5b58;&#x4e24;&#x4e2a;&#x7cfb;&#x7edf;&#x7248;&#x672c;&#x53f7;&#x907f;&#x514d;&#x4e86;&#x52a0;&#x9501;"/>
<node CREATED="1521092543563" ID="ID_1220932538" MODIFIED="1521092564271" TEXT="&#x53ea;&#x5728; REPEATABLE READ &#x548c; READ COMMITTED &#x4e0b;&#x5de5;&#x4f5c;"/>
</node>
</node>
<node CREATED="1521092854156" ID="ID_1490282168" MODIFIED="1521092867887" POSITION="right" TEXT="MySQL &#x5b58;&#x50a8;&#x5f15;&#x64ce;">
<node CREATED="1521092878000" ID="ID_876913173" MODIFIED="1521092947805" TEXT="&#x5927;&#x5c0f;&#x5199;&#x654f;&#x611f;&#xff1a; window&#x4e2d;&#x5927;&#x5c0f;&#x5199;&#x4e0d;&#x654f;&#x611f;&#xff0c; Unix&#x4e2d;&#x5927;&#x5c0f;&#x5199;&#x654f;&#x611f;"/>
</node>
</node>
</map>
