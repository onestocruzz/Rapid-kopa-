import os
import re
import sys

def replace_in_file(file_path, replacements):
    if not os.path.exists(file_path):
        print(f"Warning: File {file_path} not found.")
        return

    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()

    new_content = content
    for old_val, new_val in replacements.items():
        if old_val in new_content:
            new_content = new_content.replace(old_val, new_val)
            print(f"  Replaced in {file_path}: {old_val} -> {new_val}")
        else:
            print(f"  Warning: Pattern '{old_val}' not found in {file_path}")

    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(new_content)

def main():
    print("=== Rapid Kopa Credential Updater ===")
    
    # 1. Collect new credentials
    print("\nPlease enter your new credentials (leave blank to keep current):")
    
    fb_app_id = input("New Facebook App ID: ").strip()
    fb_client_token = input("New Facebook Client Token: ").strip()
    fb_banner_id = input("New Facebook Banner Ad ID: ").strip()
    fb_interstitial_id = input("New Facebook Interstitial Ad ID: ").strip()
    onesignal_id = input("New OneSignal App ID: ").strip()

    # 2. Define replacements
    # Note: Using the current values found in the codebase as keys
    fb_replacements = {}
    if fb_app_id:
        fb_replacements["1014121862573043"] = fb_app_id
    if fb_client_token:
        fb_replacements["150a924ee5bb2fb986db171366b78a0d"] = fb_client_token
    if fb_banner_id:
        fb_replacements["1373174626565653_1373175369898912"] = fb_banner_id
    if fb_interstitial_id:
        fb_replacements["1373174626565653_1373178633231919"] = fb_interstitial_id

    onesignal_replacements = {}
    if onesignal_id:
        onesignal_replacements["02aa0c46-3f1e-4839-9101-64637602b91c"] = onesignal_id

    # 3. Apply replacements
    print("\nUpdating files...")
    
    if fb_replacements:
        replace_in_file("app/src/main/res/values/strings.xml", fb_replacements)
    
    if onesignal_replacements:
        replace_in_file("app/src/main/java/com/rapidkopainc/rapidkopa/app.java", onesignal_replacements)

    print("\nCredential update complete!")
    print("\nReminder: To update Firebase, please manually replace the 'app/google-services.json' file with your own from the Firebase Console.")

if __name__ == "__main__":
    main()
