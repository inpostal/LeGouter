<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>會員註冊</title>
    <link rel="stylesheet" href="<c:url value='/front-end/member/Sam_CSS/style_register.css'/>">
</head>

<body>
		<%@ include file="/front-end/Header.jsp" %>
		
	    <div class="member-container">
	        <p>會員註冊</p>
	        <form id="form" action="<c:url value='/member/register'/>" method="post">
	
	            <label for="name"><b>姓名</b></label>
	            <c:if test="${inputNameErrMsg != null}">
						<font style="color: red">${inputNameErrMsg}</font>
				</c:if>
	            <input type="text" placeholder="輸入姓名" name="name" required value="${name}" >
	
	            <label for="account"><b>帳號</b></label>
	            <c:if test="${inputAccountErrMsg != null}">
						<font style="color: red">${inputAccountErrMsg}</font>
				</c:if>
	            <input type="text" placeholder="輸入帳號" name="account" required value="${account}">
	
	            <label for="password"><b>密碼</b></label>
	            <c:if test="${inputPasswordErrMsg != null}">
						<font style="color: red">${inputPasswordErrMsg}</font>
				</c:if>
	            <input type="password" placeholder="輸入密碼" name="password" required value="${password}">
	
	            <label for="gender"><b>性別</b></label>
	            <select name="gender" required value="${gender}">
	                <option value="f">女</option>
	                <option value="m">男</option>
	            </select>
	
	            <label for="phone"><b>電話</b></label>
	            <c:if test="${inputPhoneErrMsg != null}">
						<font style="color: red">${inputPhoneErrMsg}</font>
				</c:if>
	            <input type="text" placeholder="輸入電話" name="phone" required value="${phone}">
	
				
	            <label for="email"><b>信箱</b></label>
	            <c:if test="${inputMailErrMsg != null}">
						<font style="color: red">${inputMailErrMsg}</font>
				</c:if>
	            <input type="email" placeholder="輸入信箱" name="email" required value="${email}">
	            
	            
	            <label for="city">居住縣市:</label><br>
	            <select id="city" name="city" >
	            	
	            </select><br>
	            <label for="district">居住地區:</label><br>
	            <select id="district" name="district" value="${district}"></select><br>
	            <c:if test="${inputAddrErrMsg != null}">
						<font style="color: red">${inputAddrErrMsg}</font><br>
				</c:if>
	            <label for="address">詳細地址:</label><br>
	            <input type="text" id="address" name="address" value="${address}"><br>
	
	
	            <label for="birthday"><b>生日</b></label>
	            <input type="date" name="birthday" required value="${birthday}">
	
	            <button type="submit" id="submit">註冊</button>
	        </form>
	    </div>

	<%@ include file="/front-end/Footer.jsp" %>
	
    <script>
        var cityDistrict = {
            '台北市': ['中正區', '大同區', '中山區', '松山區', '大安區', '萬華區', '信義區', '士林區', '北投區', '內湖區', '南港區', '文山區'],
            '新北市': ['板橋區', '三重區', '中和區', '永和區', '新莊區', '新店區', '樹林區', '鶯歌區', '三峽區', '淡水區', '汐止區', '瑞芳區', '土城區', '蘆洲區', '五股區', '泰山區', '林口區', '深坑區', '石碇區', '坪林區', '三芝區', '石門區', '八里區', '平溪區', '雙溪區', '貢寮區', '金山區', '萬里區', '烏來區'],
            '桃園市': ['桃園區', '中壢區', '大溪區', '楊梅區', '蘆竹區', '龜山區', '八德區', '龍潭區', '平鎮區', '新屋區', '觀音區', '復興區'],
            '台中市': ['中區', '東區', '南區', '西區', '北區', '北屯區', '西屯區', '南屯區', '太平區', '大里區', '霧峰區', '烏日區', '豐原區', '后里區', '石岡區', '東勢區', '和平區', '新社區', '潭子區', '大雅區', '神岡區', '大肚區', '沙鹿區', '龍井區', '梧棲區', '清水區', '大甲區', '外埔區', '大安區', '石洞區', '石里區', '霧峰營區'],
            '台南市': ['中西區', '東區', '南區', '北區', '安平區', '安南區', '永康區', '歸仁區', '新化區', '左鎮區', '玉井區', '楠西區', '南化區', '仁德區', '關廟區', '龍崎區', '官田區', '麻豆區', '佳里區', '西港區', '七股區', '將軍區', '學甲區', '北門區', '新營區', '後壁區', '白河區', '東山區', '六甲區', '下營區', '柳營區', '鹽水區', '善化區', '大內區', '山上區', '新市區', '安定區'],
            '高雄市': ['新興區', '前金區', '苓雅區', '鹽埕區', '鼓山區', '旗津區', '前鎮區', '三民區', '楠梓區', '小港區', '左營區', '仁武區', '大社區', '岡山區', '路竹區', '阿蓮區', '田寮區', '燕巢區', '橋頭區', '梓官區', '彌陀區', '永安區', '湖內區', '鳳山區', '大寮區', '林園區', '鳥松區', '大樹區', '旗山區', '美濃區', '六龜區', '內門區', '杉林區', '甲仙區', '桃源區', '那瑪夏區', '茂林區', '茄萣區'],
            '基隆市': ['仁愛區', '信義區', '中正區', '中山區', '安樂區', '暖暖區', '七堵區'],
            '新竹市': ['東區', '北區', '香山區'],
            '嘉義市': ['東區', '西區'],
            '新竹縣': ['竹北市', '竹東鎮', '新埔鎮', '關西鎮', '湖口鄉', '新豐鄉', '峨眉鄉', '寶山鄉', '北埔鄉', '芎林鄉', '橫山鄉', '尖石鄉', '五峰鄉'],
            '苗栗縣': ['苗栗市', '頭份市', '竹南鎮', '後龍鎮', '通霄鎮', '苑裡鎮', '卓蘭鎮', '造橋鄉', '西湖鄉', '頭屋鄉', '公館鄉', '銅鑼鄉', '三義鄉', '大湖鄉', '獅潭鄉', '三灣鄉', '南庄鄉', '泰安鄉'],
            '彰化縣': ['彰化市', '員林市', '和美鎮', '鹿港鎮', '溪湖鎮', '二林鎮', '田中鎮', '北斗鎮', '花壇鄉', '芬園鄉', '大村鄉', '永靖鄉', '伸港鄉', '線西鄉', '福興鄉', '秀水鄉', '埔心鄉', '埔鹽鄉', '大城鄉', '芳苑鄉', '竹塘鄉', '社頭鄉', '二水鄉', '田尾鄉', '埤頭鄉', '溪州鄉'],
            '南投縣': ['南投市', '埔里鎮', '草屯鎮', '竹山鎮', '集集鎮', '名間鄉', '鹿谷鄉', '中寮鄉', '魚池鄉', '國姓鄉', '水里鄉', '信義鄉', '仁愛鄉'],
            '雲林縣': ['斗六市', '斗南鎮', '虎尾鎮', '西螺鎮', '土庫鎮', '北港鎮', '古坑鄉', '大埤鄉', '莿桐鄉', '林內鄉', '二崙鄉', '崙背鄉', '麥寮鄉', '東勢鄉', '褒忠鄉', '臺西鄉', '元長鄉', '四湖鄉', '口湖鄉', '水林鄉'],
            '嘉義縣': ['太保市', '朴子市', '布袋鎮', '大林鎮', '民雄鄉', '溪口鄉', '新港鄉', '六腳鄉', '東石鄉', '義竹鄉', '鹿草鄉', '水上鄉', '中埔鄉', '竹崎鄉', '梅山鄉', '番路鄉', '大埔鄉', '阿里山鄉'],
            '屏東縣': ['屏東市', '潮州鎮', '東港鎮', '恆春鎮', '萬丹鄉', '長治鄉', '麟洛鄉', '九如鄉', '里港鄉', '鹽埔鄉', '高樹鄉', '萬巒鄉', '內埔鄉', '竹田鄉', '新埤鄉', '枋寮鄉', '新園鄉', '崁頂鄉', '林邊鄉', '南州鄉', '佳冬鄉', '琉球鄉', '車城鄉', '滿州鄉', '枋山鄉', '霧台鄉', '瑪家鄉', '泰武鄉', '來義鄉', '春日鄉', '獅子鄉', '牡丹鄉', '三地門鄉'],
            '宜蘭縣': ['宜蘭市', '羅東鎮', '蘇澳鎮', '頭城鎮', '礁溪鄉', '壯圍鄉', '員山鄉', '冬山鄉', '五結鄉', '三星鄉', '大同鄉', '南澳鄉'],
            '花蓮縣': ['花蓮市', '鳳林鎮', '玉里鎮', '新城鄉', '吉安鄉', '壽豐鄉', '光復鄉', '豐濱鄉', '瑞穗鄉', '富里鄉', '秀林鄉', '萬榮鄉', '卓溪鄉'],
            '台東縣': ['台東市', '成功鎮', '關山鎮', '長濱鄉', '海端鄉', '池上鄉', '東河鄉', '鹿野鄉', '延平鄉', '卑南鄉', '金峰鄉', '大武鄉', '達仁鄉', '綠島鄉', '蘭嶼鄉', '太麻里鄉'],
            '金門縣': ['金城鎮', '金湖鎮', '金沙鎮', '金寧鄉', '烈嶼鄉', '烏坵鄉'],
            '連江縣': ['南竿鄉', '北竿鄉', '莒光鄉', '東引鄉']
        };


        var citySelect = document.getElementById('city');
        var districtSelect = document.getElementById('district');

        // 初始化縣市選項
        for (var city in cityDistrict) {
            var option = document.createElement('option');
            option.text = city;
            option.value = city;
            citySelect.add(option);
        }

        // 當縣市選項變動時，更新地區選項
        citySelect.addEventListener('change', function () {
            var city = citySelect.value;
            var districts = cityDistrict[city];

            // 清空地區選項
            while (districtSelect.options.length > 0) {
                districtSelect.remove(0);
            }

            // 更新地區選項
            for (var i = 0; i < districts.length; i++) {
                var option = document.createElement('option');
                option.text = districts[i];
                option.value = districts[i];
                districtSelect.add(option);
            }
        });

        // 初始化地區選項
        citySelect.dispatchEvent(new Event('change'));
    </script>
</body>

</html>