package org.OrangeHrmDataProviders;

import org.testng.annotations.DataProvider;

public class EmployeeTableDataProvider {

    @DataProvider(name = "EmployeeDataTable1")
    public Object[][] getEmployeeTableContent() {
        Object[][] employeeTable = new Object[][]{
                {"Employee Id", "Name", "Job Title", "Employment Status", "Sub Unit", "Cost Center", "Location", "Supervisor"},
                {"0123", "Mazie Abraham", "Marketing Executive", "Full-Time Permanent", "Marketing", "0007 - Cost Center (Marketing)", "Australia office", "Dereck Morris"},
                {"1061", "Odis Adalwin", "Vice President - Human Resources", "Full-Time Permanent", "Human Resources", "0005 - Cost center (Administration)", "Canadian Development Center", "Jacqueline Wagner"},
                {"1055", "Brody Alan", "Senior Manager Technical Support", "Full-Time Permanent", "Information Technology", "0001 - Cost Center (IT)", "US Office", "Miguel Mason"},
                {"0125", "Mary Alcala", "Production Co-ordinator", "Full-Time Contract", "Production", "0006 - Cost center (Production)", "Australia office", "Rebecca Harmony"},
                {"EMP101", "Sofia Almeida", "", "", "", "", "Canadian Development Center", ""},
                {"1058", "Peter Anderson", "CRO", "Full-Time Permanent", "Sales", "0004 - Cost Center (Sales)", "US Office", "Carla Donovan"},
                {"1002", "Leah Andrews", "CCO", "Full-Time Probation", "Information Technology", "0009 - Cost center (QA)", "UK Office", "Carla Donovan"},
                {"1072", "Tanya Arva", "Software Architect", "Full-Time Permanent", "Engineering", "0002 - Cost Center (Engineering)", "India Office", "Miguel Mason"},
                {"1080", "Amadi Aswad", "Senior Software Development Manager", "Full-Time Permanent", "Engineering", "0002 - Cost Center (Engineering)", "India Office", "Eric Harris"},
                {"1144", "Lukas Bauer", "Regional HR Manager", "Full-Time Permanent", "Human Resources", "0008 - Cost Center (Architecture)", "German Office", "Anna Schmidt"},
                {"1149", "Johanna Becker", "Customer Support Executive", "Full-Time Contract", "Customer Success", "0008 - Cost Center (Architecture)", "German Office", "Tim Müller"},
                {"1122", "Brad Bellic", "Software Engineer", "Full-Time Permanent", "Engineering", "0002 - Cost Center (Engineering)", "US Office", ""},
                {"EMP107", "Chloe Marie Bennett", "", "", "", "", "Mexico Office", ""},
                {"1139", "Léa Bernard", "Local Marketing Manager", "Full-Time Permanent", "Marketing", "0008 - Cost Center (Architecture)", "France Office", "Julien Rousseau"},
                {"1071", "Cece Bonaparte", "Talent Acquisition Manager", "Full-Time Permanent", "Human Resources", "0005 - Cost center (Administration)", "UK Office", "Jacqueline Wagner"},
                {"0119", "Caitlyn Bonwick", "HR Executive", "Full-Time Contract", "Human Resources", "0005 - Cost center (Administration)", "Australia office", "Katerina Skonis"},
                {"1117", "Brian Butler", "Regional Sales Director", "Full-Time Permanent", "Marketing", "0007 - Cost Center (Marketing)", "India Office", "Russell Hamilton"},
                {"1032", "Steven Caldwell", "Sales Manager", "Full-Time Permanent", "Sales", "0004 - Cost Center (Sales)", "US Office", "David Grossi"},
                {"1158", "Ayana Campbell", "Junior QA Engineer", "Full-Time Probation", "Quality assurance (QA)", "0009 - Cost center (QA)", "Jamaica HQ", "Maleeka Johnson"},
                {"1104", "Charlie Carter", "Principal Software Engineer", "Full-Time Permanent", "Technical Support", "0002 - Cost Center (Engineering)", "Canadian Development Center", "Khloe Jayden"},
                {"1102", "Chang Cheng", "Senior Software Development Manager", "Full-Time Permanent", "Engineering", "0002 - Cost Center (Engineering)", "India Office", "Eric Harris"},
                {"1171", "Mei Ling Chua", "Marketing Executive", "Full-Time Probation", "Marketing", "0007 - Cost Center (Marketing)", "Singapore Regional HQ", "Wei Tan"},
                {"1083", "Chenzira Chuki", "Lead QA Engineer", "Full-Time Permanent", "Quality assurance (QA)", "0009 - Cost center (QA)", "South Africa Satellite Office", "Amadi Aswad"},
                {"1110", "Paul Collings", "Local Marketing Manager", "Full-Time Contract", "Production", "0006 - Cost center (Production)", "Canadian Development Center", "Jackson Smith"},
                {"1039", "Christoper Cooper", "Comptroller", "Full-Time Permanent", "Finance", "0003 - Cost Center (Finance)", "US Office", "David Fernandez"},
                {"1093", "Robert Craig", "Regional Sales Manager", "Full-Time Permanent", "Product and Training", "0004 - Cost Center (Sales)", "India Office", "Nina Patel"},
                {"1165", "Maria Cruz", "Senior QA Engineer", "Full-Time Permanent", "Architecture Team", "0008 - Cost Center (Architecture)", "Philippine call center", "Armando Santos"},
                {"0129", "Alannah Daglish", "Associate Support Engineer", "Full-Time Probation", "Information Technology", "0008 - Cost Center (Architecture)", "Australia office", "Aaliyah Haq"},
                {"1121", "Andrew Daley", "IT Technical Support", "Full-Time Permanent", "Information Technology", "00010 - UK Business Unit", "US Office", "Aaliyah Haq"},
                {"201", "Anthony Davies", "Project Manager", "Full-Time Permanent", "Architecture Team", "0008 - Cost Center (Architecture)", "India Office", ""},
                {"1123", "Paul Davis", "Software Engineer", "Full-Time Contract", "Engineering", "0002 - Cost Center (Engineering)", "US Office", ""},
                {"1038", "Lincoln Davis", "Senior Manager- Digital Marketing", "Full-Time Permanent", "Marketing", "0001 - Cost Center (IT)", "US Office", "Russell Hamilton"},
                {"1127", "Lisa De Zousa", "Sales Executive", "Full-Time Permanent", "Sales", "0004 - Cost Center (Sales)", "US Office", ""},
                {"1015", "Carla Donovan", "CEO", "Full-Time Permanent", "Marketing", "0007 - Cost Center (Marketing)", "US Office", ""},
                {"1142", "Laura Dubois", "Marketing Executive", "Full-Time Permanent", "Marketing", "0008 - Cost Center (Architecture)", "France Office", "Léa Bernard"},
                {"1135", "Camille Dubois", "Senior Manager- Regional Sales", "Full-Time Permanent", "Sales", "0008 - Cost Center (Architecture)", "France Office", "Michael Nelson"},
                {"1068", "Alice Duval", "Senior Sales Manager", "Full-Time Permanent", "Customer Success", "0004 - Cost Center (Sales)", "UK Office", "Michael Nelson"},
                {"1081", "Ehioze Ebo", "Engineer Manager", "Full-Time Permanent", "Technical Support", "0002 - Cost Center (Engineering)", "India Office", "Eric Harris"},
                {"1118", "Ralph Edwards", "Art Director", "Full-Time Permanent", "Marketing", "0007 - Cost Center (Marketing)", "India Office", "Dereck Morris"},
                {"1059", "Amy Elliot", "Assistant Manager - HR", "Full-Time Permanent", "Human Resources", "0005 - Cost center (Administration)", "Canadian Development Center", "Odis Adalwin"},
                {"0120", "Stephan Fassbinder", "Production Co-ordinator", "Full-Time Contract", "Production", "0006 - Cost center (Production)", "Jamaica HQ", "Jackson Smith"},
                {"0203", "David Fernandez", "CFO", "Full-Time Permanent", "Finance", "0003 - Cost Center (Finance)", "US Office", "Carla Donovan"},
                {"1097", "Tian Fieur", "Regional HR Manager", "Full-Time Permanent", "Human Resources", "0005 - Cost center (Administration)", "India Office", "Anna Schmidt"},
                {"1146", "Maximilian Fischer", "Senior Customer Success Manager", "Full-Time Permanent", "Customer Success", "0008 - Cost Center (Architecture)", "German Office", "Leah Andrews"},
                {"1050", "Jenny Fisher", "Software Engineer", "Part-Time Contract", "Engineering", "0002 - Cost Center (Engineering)", "Canadian Development Center", "Khloe Jayden"},
                {"1103", "Fabienne Gabor", "Assistant Manager - HR", "Full-Time Permanent", "Human Resources", "0005 - Cost center (Administration)", "India Office", "Odis Adalwin"},
                {"1092", "Mason Gabriel", "Sales Executive", "Full-Time Permanent", "Sales", "0004 - Cost Center (Sales)", "US Office", "Robert Craig"},
                {"1074", "Goutam Ganesh", "Principal Software Engineer", "Full-Time Permanent", "Engineering", "0002 - Cost Center (Engineering)", "India Office", "Tanya Arva"},
                {"1035", "Martín García", "Technical Support Engineer", "Full-Time Permanent", "Quality assurance (QA)", "0009 - Cost center (QA)", "Mexico Office", "Brody Alan"},
                {"1141", "Marion Girard", "SEO Specialist", "Full-Time Permanent", "Marketing", "0007 - Cost Center (Marketing)", "France Office", "Léa Bernard"}
        };
        return employeeTable;
    }
}
