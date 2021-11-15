package com.example.patentproject.entity.vo;
/*
 * @author p78o2
 * @date 2021/11/9
 */

public class ResltExcelVo {
//    公司名
    public String companyName;
//    发明授权
    public float inventionAuthorizationNum;
//    发明申请-有效
    public float inventionApplicationValid;
//    发明申请-审中
    public float inventionApplicationPending;
//    发明申请-PCT-有效期内
    public float inventionApplicationPCT;
//    实用新型
    public float utilityModel;
//    短期专利
    public float shortTermPatent;
//    外观设计
    public float appearanceDesign;
//    被引证次数
    public int numberOfCitations;
//    许可次数
    public int licensesNum;
//    转让次数
    public int transfersNum;

    public ResltExcelVo() {
    }

    @Override
    public String toString() {
        return "ResltExcelVo{" +
                "companyName='" + companyName + '\'' +
                ", inventionAuthorizationNum=" + inventionAuthorizationNum +
                ", inventionApplicationValid=" + inventionApplicationValid +
                ", inventionApplicationPending=" + inventionApplicationPending +
                ", inventionApplicationPCT=" + inventionApplicationPCT +
                ", utilityModel=" + utilityModel +
                ", shortTermPatent=" + shortTermPatent +
                ", appearanceDesign=" + appearanceDesign +
                ", numberOfCitations=" + numberOfCitations +
                ", licensesNum=" + licensesNum +
                ", transfersNum=" + transfersNum +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getInventionAuthorizationNum() {
        return inventionAuthorizationNum;
    }

    public void setInventionAuthorizationNum(float inventionAuthorizationNum) {
        this.inventionAuthorizationNum = inventionAuthorizationNum;
    }

    public float getInventionApplicationValid() {
        return inventionApplicationValid;
    }

    public void setInventionApplicationValid(float inventionApplicationValid) {
        this.inventionApplicationValid = inventionApplicationValid;
    }

    public float getInventionApplicationPending() {
        return inventionApplicationPending;
    }

    public void setInventionApplicationPending(float inventionApplicationPending) {
        this.inventionApplicationPending = inventionApplicationPending;
    }

    public float getInventionApplicationPCT() {
        return inventionApplicationPCT;
    }

    public void setInventionApplicationPCT(float inventionApplicationPCT) {
        this.inventionApplicationPCT = inventionApplicationPCT;
    }

    public float getUtilityModel() {
        return utilityModel;
    }

    public void setUtilityModel(float utilityModel) {
        this.utilityModel = utilityModel;
    }

    public float getShortTermPatent() {
        return shortTermPatent;
    }

    public void setShortTermPatent(float shortTermPatent) {
        this.shortTermPatent = shortTermPatent;
    }

    public float getAppearanceDesign() {
        return appearanceDesign;
    }

    public void setAppearanceDesign(float appearanceDesign) {
        this.appearanceDesign = appearanceDesign;
    }

    public int getNumberOfCitations() {
        return numberOfCitations;
    }

    public void setNumberOfCitations(int numberOfCitations) {
        this.numberOfCitations = numberOfCitations;
    }

    public int getLicensesNum() {
        return licensesNum;
    }

    public void setLicensesNum(int licensesNum) {
        this.licensesNum = licensesNum;
    }

    public int getTransfersNum() {
        return transfersNum;
    }

    public void setTransfersNum(int transfersNum) {
        this.transfersNum = transfersNum;
    }

    public ResltExcelVo(String companyName, float inventionAuthorizationNum, float inventionApplicationValid, float inventionApplicationPending, float inventionApplicationPCT, float utilityModel, float shortTermPatent, float appearanceDesign, int numberOfCitations, int licensesNum, int transfersNum) {
        this.companyName = companyName;
        this.inventionAuthorizationNum = inventionAuthorizationNum;
        this.inventionApplicationValid = inventionApplicationValid;
        this.inventionApplicationPending = inventionApplicationPending;
        this.inventionApplicationPCT = inventionApplicationPCT;
        this.utilityModel = utilityModel;
        this.shortTermPatent = shortTermPatent;
        this.appearanceDesign = appearanceDesign;
        this.numberOfCitations = numberOfCitations;
        this.licensesNum = licensesNum;
        this.transfersNum = transfersNum;
    }
}
