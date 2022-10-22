const common = {
	getYYYYMM : cnt => {
		const adjustDate = common.addMonths(cnt);
		const yyyy = adjustDate.getFullYear().toString();
		const mm = (adjustDate.getMonth() + 1).toString().padStart(2,0);
		return yyyy.concat('-').concat(mm);		
	},
	addMonths : (cnt, date = new Date()) => {
		date.setMonth(date.getMonth() + cnt);
		return date;		
	},
}