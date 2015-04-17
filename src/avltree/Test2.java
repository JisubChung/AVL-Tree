package avltree;

public class Test2 {

	public static void main(String[] args) {
		StringAVLTreeXtra t = new StringAVLTreeXtra();
		String str;
		int num = 0, ct, ran = 87, line = 1;
		char action;
		String s = "imaoinaoioaoipaoiqaoilaoikaoikdoikgoikfo";//ikeo";
		// add lines like this when you have delete working
		// s = s + "dkeodkfodpao";
		s = s + "dkao"
				+ "dkfo"
				+ "dpao"
				+ "ippo"
				+ "injo"
				+ "inio"
				+ "inoo"
				+ "ikqo"
				+ "ilro";
		
		do {
			action = s.charAt(0);
			if (action == 'i') {   // insert
				str = s.substring(1,3);
				s = s.substring(3, s.length());
				t.insert(str);
			} else if (action == 'd') {  // delete
				str = s.substring(1,3);
				s = s.substring(3, s.length());
				t.delete(str);
			} else if (action == 'n') {  // new tree -- wipe out the tree and start over
				s = s.substring(1, s.length());
				t = new StringAVLTreeXtra();
			} else {  // no other choice, then output the tree
				s = s.substring(1, s.length());
				t.display();
				System.out.println(" - " + line++ + ".\n");
			}
		} while (s.length() != 0);
	}
}

class StringAVLTreeXtra extends StringAVLTree {

	public StringAVLTreeXtra() {
		super();
	}

	public void display() {
		paren_out(getRoot());
		System.out.println();
		bal_out(getRoot());
	}

	public void paren_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			paren_out(t.getLeft());
			if (t.getVal().length() <= 1)
				System.out.print(" ");
			System.out.print(t.getVal());
			paren_out(t.getRight());
			System.out.print(")");
		}
	}

	public void bal_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			bal_out(t.getLeft());
			if (t.getBalance() == -1)
				System.out.print(t.getBalance());
			else
				System.out.print(" " + t.getBalance());
			bal_out(t.getRight());
			System.out.print(")");
		}
	}
}













/*



public class Test2 {

	public static void main(String[] args) {
		StringAVLTreeXtra t = new StringAVLTreeXtra();
		String str;
		int ct, ran = 87, line = 1, ansct=0, num;
		char action, letter;
		String s = "oimaoinaoioaoipaoiqaoilaoikaoikdikgikfikeoI20oI99onI30odhcrodicjodieiodkhxodiododzzzodnzzo";
		s += "dourodnrmodmldodlovodgxcodfclodsjvodpmtodaaao";
		String ans[] = {
				"0 0 0",
				"(ma)(0)1 1 1",
				"(ma(na))(1(0))1 2 1",
				"((ma)na(oa))((0)0(0))2 2 3",
				"((ma)na(oa(pa)))((0)1(1(0)))2 3 2",
				"((ma)na((oa)pa(qa)))((0)1((0)0(0)))3 3 4",
				"(((la)ma)na((oa)pa(qa)))(((0)-1)0((0)0(0)))3 3 5",
				"(((ka)la(ma))na((oa)pa(qa)))(((0)0(0))0((0)0(0)))4 3 7",
				"(((ka)kd((ke)kf))kg((la(ma))na((oa)pa(qa))))(((0)1((0)-1))0((1(0))0((0)0(0))))5 4 8",
				"((((((aqu)cdf)ejc((hdo)ka(kae)))kd((ke)kf))kg(((la)lhx(lzc))ma(mlh(mrg))))na((((naj)oa(orq))pa(pln(pqr)))qa(((qiq(sgb))tvb(uem))uwp(yfo(zif)))))((((((0)-1)0((0)0(0)))-1((0)-1))-1(((0)0(0))0(1(0))))0((((0)0(0))0(1(0)))1(((1(0))-1(0))-1(1(0)))))13 6 20",
				"(((((((aka(apa))aqs(aqu(axb)))cdf(((cff)chj)clw((cug)cxs(ddg))))dkr((dpx)dsx((dvd)dyp(edc))))ejc((((epa)esn((fgq)fwu))gbg((giz(gly))gma(gws)))hdo((((hkx)hqv)iry((ive)ixt(ixy)))jgz((joh)jyc))))ka((((kae(kao))kd((ke)kf))kg((((kjj)kpc)la(lds))lev(lhx(lne))))loj(((lsc)lzc)ma(((mfc)mlh)mrg(mrj(mwq))))))na((((((naj)net(nmn))nnq((nps)nvq))oa(((ocx)ogx((onb)orq(otq)))pa((pln)pph(pqr(pzv)))))qa((((qei)qez(qiq))qpx((qrs)qsm((qyc)rfn)))rku(((rmq)rpr((rxu)seh))sgb(((shl)shv(ssz))tdl(tje(tqf))))))tvb((((ucx)uel((uem)uio(uje)))uwp((((vco)vik(vlx))vod((vzc)wdk(wkp)))wmh((wua)xic)))xjt((((xmp)xvh(xvz))yan(ybh))yfo(((yil)ynt(ysk))zfc(zif(zqc)))))))(((((((1(0))0(1(0)))0(((0)-1)0((0)0(0))))-1((0)1((0)0(0))))0((((0)1((0)-1))0((1(0))-1(0)))0((((0)-1)0((0)0(0)))-1((0)-1))))0((((1(0))0((0)-1))1((((0)-1)-1(0))-1(1(0))))-1(((0)-1)1(((0)-1)0(1(0))))))0((((((0)0(0))0((0)-1))1(((0)1((0)0(0)))0((0)1(1(0)))))0((((0)0(0))1((0)1((0)-1)))0(((0)1((0)-1))0(((0)0(0))0(1(0))))))0((((0)1((0)0(0)))1((((0)0(0))0((0)0(0)))-1((0)-1)))-1((((0)0(0))-1(0))0(((0)0(0))0(1(0)))))))55 8 88",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc(((hcr)icj)iei((iod)khx(lov))))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))(((((0)0(0))0((0)0(0)))0(((0)-1)0((0)0(0))))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))14 6 23",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc((icj)iei((iod)khx(lov))))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))(((((0)0(0))0((0)0(0)))0((0)1((0)0(0))))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))14 6 22",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc((iei(iod))khx(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))(((((0)0(0))0((0)0(0)))0((1(0))-1(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))13 6 20",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc((iod)khx(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))(((((0)0(0))0((0)0(0)))-1((0)0(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))13 6 20",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc(iod(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))(((((0)0(0))0((0)0(0)))-1(1(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))12 6 18",
				"((((blp)bpj(bxa))cer(((cfw)cst(fcl))gxc(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1(((0)0(0))-1(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))12 6 17",
				"((((blp)bpj(bxa))cer(((cfw)cst(fcl))gxc(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1(((0)0(0))-1(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))12 6 17",
				"((((blp)bpj(bxa))cer(((cfw)cst(fcl))gxc(lov)))mld((((nfn)njv(nrm))our((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1(((0)0(0))-1(0)))1((((0)0(0))0((0)-1))1(((0)0(0))1((1(0))-1(0)))))12 6 17",
				"((((blp)bpj(bxa))cer(((cfw)cst(fcl))gxc(lov)))mld((((nfn)njv)nrm((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1(((0)0(0))-1(0)))1((((0)-1)0((0)-1))1(((0)0(0))1((1(0))-1(0)))))11 6 15",
				"((((blp)bpj(bxa))cer(((cfw)cst(fcl))gxc(lov)))mld(((nfn)njv((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1(((0)0(0))-1(0)))1(((0)1((0)-1))1(((0)0(0))1((1(0))-1(0)))))11 6 14",
				"((((blp)bpj(bxa))cer((cfw)cst((fcl)gxc)))lov(((nfn)njv((pih)pmt))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue)))))((((0)0(0))1((0)1((0)-1)))1(((0)1((0)-1))1(((0)0(0))1((1(0))-1(0)))))10 6 12",
				"(((((blp)bpj(bxa))cer((cfw)cst(fcl)))gxc((nfn)njv((pih)pmt)))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))0((0)0(0)))0((0)1((0)-1)))0(((0)0(0))1((1(0))-1(0))))10 5 16",
				"(((((blp)bpj(bxa))cer((cfw)cst))fcl((nfn)njv((pih)pmt)))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))0((0)-1))0((0)1((0)-1)))0(((0)0(0))1((1(0))-1(0))))9 5 14",
				"(((((blp)bpj(bxa))cer(cfw))cst((nfn)njv((pih)pmt)))sjv(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))-1(0))0((0)1((0)-1)))0(((0)0(0))1((1(0))-1(0))))9 5 13",
				"(((((blp)bpj(bxa))cer(cfw))cst((nfn)njv(pih)))pmt(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))-1(0))-1((0)0(0)))0(((0)0(0))1((1(0))-1(0))))9 5 13",
				"(((((blp)bpj(bxa))cer(cfw))cst((nfn)njv))pih(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))-1(0))-1((0)-1))0(((0)0(0))1((1(0))-1(0))))8 5 11",
				"(((((blp)bpj(bxa))cer(cfw))cst((nfn)njv))pih(((sjw)vkg(wcs))xeh((yif(yzm))znv(zue))))(((((0)0(0))-1(0))-1((0)-1))0(((0)0(0))1((1(0))-1(0))))8 5 11",
				""
		};
	
		 
		do {
			action = s.charAt(0);
			if (action == 'i') {   // insert
				str = s.substring(1,3);
				s = s.substring(3, s.length());
				t.insert(str);
			} else if (action == 'd') {  // delete
				str = s.substring(1,4);
				s = s.substring(4, s.length());
				t.delete(str);
			} else if (action == 'n') {  // new tree -- wipe out the tree and start over
				s = s.substring(1, s.length());
				t = new StringAVLTreeXtra();
			} else if (action == 'I') {
	            num = (s.charAt(1) - '0') * 10 + s.charAt(2) - '0';
	            s = s.substring(3, s.length());
	            for (ct = 1; ct <= num; ct++) {
	               ran = (ran * 101 + 103) % 1000003;
	               str= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               t.insert(str);
	            }
	        }
			else {  // no other choice, then compare
				s = s.substring(1, s.length());
				System.out.print(line++ + ". ");
				if (t.toString2().compareTo(ans[ansct]) == 0)
					System.out.println(" Answers match.   ");
				else {
					System.out.print("   *** NO MATCH ***   ");
					System.out.println(t.toString2());
				}
				//t.display();
				ansct++;
			}
		} while (s.length() != 0);
	}
}

class StringAVLTreeXtra extends StringAVLTree {

	public StringAVLTreeXtra() {
		super();
	}

	public void display() {
		paren_out(getRoot());
		System.out.println();
		bal_out(getRoot());
	}

	public void paren_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			paren_out(t.getLeft());
			if (t.getVal().length() <= 1)
				System.out.print(" ");
			System.out.print(t.getVal());
			paren_out(t.getRight());
			System.out.print(")");
		}
	}

	public void bal_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			bal_out(t.getLeft());
			if (t.getVal().length() == 3)
				System.out.print(" ");
			if (t.getBalance() == -1)
				System.out.print(t.getBalance());
			else
				System.out.print(" " + t.getBalance());
			bal_out(t.getRight());
			System.out.print(")");
		}
	}
	
	public String paren_out1(StringAVLNode t) {
		String s;
		if (t == null) {
			s = new String();
		} else {
			s="(" + paren_out1(t.getLeft())+t.getVal()+paren_out1(t.getRight())+")";
		}
		return s;
	}

	public String bal_out1(StringAVLNode t) {
		String s;
		if (t == null) {
			s = new String();
		} else {
			s="("+bal_out1(t.getLeft())+t.getBalance()+bal_out1(t.getRight())+")";
		}
		return s;
	}
	
	public String toString2() {
			String s = new String();
			s = paren_out1(getRoot())+bal_out1(getRoot())+String.valueOf(this.leafCt())+" "+
			    String.valueOf(this.height())+" "+String.valueOf(this.balanced());
			return s;
	}
}
*/